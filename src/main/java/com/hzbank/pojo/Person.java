package com.hzbank.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/7/22 09:54
 * @Description: Person
 * @Version 1.0.0
 */
@Data
public class Person {
    private BigDecimal age;
    private String name;
    public Person(){

    }
    public Person(BigDecimal age,String name){
        this.age = age;
        this.name = name;
    }
}
