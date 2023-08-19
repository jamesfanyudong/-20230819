package com.fyd.spring.test;

import com.netflix.hystrix.*;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoHystrixService {


  private RestTemplate rest;
  // 注入系统默认的实现
  private CircuitBreakerFactory cbFactory;
 
  public DemoHystrixService(RestTemplate rest, CircuitBreakerFactory cbFactory) {
    this.rest = rest;
    this.cbFactory = cbFactory;
  }
 
  public String slow() {
    // 使用系统默认的实现创建断路器进行业务的处理
    return cbFactory.create("slow").run(() -> rest.getForObject("http://localhost:8088/demos/slow", String.class), throwable -> "fallback");
  }
 
  public String slow2() {
    // 使用自定义的断路器工厂进行业务的处理
    return cbf().create("demo-slow").run(() -> rest.getForObject("http://localhost:8088/demos/slow", String.class), throwable -> "fallback");
  }
 
  // 可以将这个定义为Bean来覆盖系统默认的实现，在系统默认的实现上有条件限定
  private CircuitBreakerFactory<HystrixCommand.Setter, HystrixCircuitBreakerFactory.HystrixConfigBuilder> cbf() {
    HystrixCircuitBreakerFactory cbf = new HystrixCircuitBreakerFactory() ;
    // 配置线程池
    HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter() ;
    threadPoolProperties.withCoreSize(5)
      .withKeepAliveTimeMinutes(5)
      .withMaxQueueSize(Integer.MAX_VALUE)
      .withQueueSizeRejectionThreshold(1000) ;
    // 配置默认的执行行为属性
    HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter() ;
    commandProperties.withCircuitBreakerEnabled(true)
    // 当请求超过了3s那么断路器就会工作进行回退（降级处理），执行上面run方法中的第二个参数
      .withExecutionTimeoutInMilliseconds(3000)
      .withRequestCacheEnabled(true)
      // 隔离策略有两种THREAD，SEMAPHORE
      // THREAD: 避免线程被阻塞
      // SEMAPHORE: 适合高并发限流处理；因为线程池的方式一般不会创建过多的线程
      // 线程是有限的，在高并发情况下是没法满足响应处理的。
      .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
		
    // 将其加入到集合中，为不同的服务创建不同的配置
    cbf.configure(builder -> {
      builder.commandProperties(commandProperties).groupName("demo") ;
    }, "demo-slow");
	    
    // 当默认的id不存在时使用这默认的配置
    cbf.configureDefault(id -> {
      HystrixCommand.Setter setter = HystrixCommand.Setter
        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("demo")) // 服务分组，大的模块
        .andCommandKey(HystrixCommandKey.Factory.asKey("demo-slow")) // 服务标识（具体服务分组中的某一个子的服务），子模块
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("demo-pools")) // 线程池名称
        .andThreadPoolPropertiesDefaults(threadPoolProperties) // 线程池相关配置
        .andCommandPropertiesDefaults(commandProperties) ; // 执行时相关属性配置 
      return setter ;
    });
    return cbf ;
  }
 
}