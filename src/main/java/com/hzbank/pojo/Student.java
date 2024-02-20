package com.hzbank.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/20 15:15
 * @Description: Student
 * @Version 1.0.0
 */
@Data
public class Student {

    private String name;
    private int age;
    private Date date;

    public Student(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }
}
