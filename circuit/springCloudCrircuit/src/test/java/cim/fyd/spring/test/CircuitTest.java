//package cim.fyd.spring.test;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
//import org.springframework.cloud.client.circuitbreaker.ConfigBuilder;
//import org.springframework.stereotype.Service;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.function.Function;
//
///**
// * @Description
// * @Auther: fyd20
// * @Date: 2023/4/21 09:54
// * @Description: CircuitTest
// * @Version 1.0.0
// */
//
//@SpringJUnitConfig
//public class CircuitTest {
//
//    private CircuitBreakerFactory circuitBreakerFactory = new CircuitBreakerFactory() {
//        @Override
//        public CircuitBreaker create(String id) {
//            return null;
//        }
//
//        @Override
//        protected ConfigBuilder configBuilder(String id) {
//            return null;
//        }
//
//        @Override
//        public void configureDefault(Function defaultConfiguration) {
//
//        }
//    };
//    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("熔断器名称");
//
//
//
//    @Test
//    public void test01(){
//        // 3. 业务代码-远程调用
//        this.circuitBreaker.run(()->{
//            return null;//远程调用
//        },Throwable ->{
//            return null; //当熔断发生时，回调方法
//        });
//    }
//
//    @Service
//    public static class DemoService {
//        private RestTemplate rest;
//        private CircuitBreakerFactory cbFactory;
//
//        public DemoService(RestTemplate rest, CircuitBreakerFactory cbFactory) {
//            this.rest = rest;
//            this.cbFactory = cbFactory;
//        }
//
//        public String slow() {
//            // 通过默认的CircuitBreakerFactory工厂创建一个指定id（名称）的断路器
//            // run方法是实际执行你的业务方法，第二个参数throwable 是当发生异常或者是执行超时
//            // 执行的回退（降级）处理
//            return cbFactory.create("slow").run(() -> rest.getForObject("/slow", String.class), throwable -> "fallback");
//        }
//    }
//}
