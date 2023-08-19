package com.fyd.spring.test;


import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/4/20 18:45
 * @Description: CircutTest
 * @Version 1.0.0
 */
public class CircutTest {

    @Service
    public static class DemoControllerService {
        private RestTemplate rest;
        private CircuitBreakerFactory cbFactory;

        public DemoControllerService(RestTemplate rest, CircuitBreakerFactory cbFactory) {
            this.rest = rest;
            this.cbFactory = cbFactory;
        }

        public String slow() {
            return cbFactory.create("slow").run(() -> rest.getForObject("/slow", String.class), throwable -> "fallback");
        }

    }


    public static void main(String[] args) {
//        CircuitBreakerFactory
//        DemoControllerService demoControllerService = new DemoControllerService(new RestTemplate(),cbf);
//        String slow = demoControllerService.slow();
//        System.out.println(slow);

    }

    private CircuitBreakerFactory<Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration, Resilience4JConfigBuilder> cbf(){
        Resilience4JCircuitBreakerFactory breakerFactory = new Resilience4JCircuitBreakerFactory();



        return null;
    }
}
