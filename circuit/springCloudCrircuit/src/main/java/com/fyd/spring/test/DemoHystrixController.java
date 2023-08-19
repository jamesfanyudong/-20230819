package com.fyd.spring.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/4/21 18:51
 * @Description: DemoHystrixController
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/demos")
public class DemoHystrixController {




        @Resource
        private DemoHystrixService demoService ;

        @GetMapping("/index")
        public Object index() {
            return demoService.slow2() ;
        }

        @GetMapping("/slow")
        public Object slow() {
            try {
                System.out.println("调用slow");
                TimeUnit.SECONDS.sleep(5) ;
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "slow" ;
        }

    }

