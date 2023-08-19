package pojo;

import lombok.Data;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/7/22 09:54
 * @Description: Person
 * @Version 1.0.0
 */
@Data
public class Person {
    private int age;
    private String name;
    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
}
