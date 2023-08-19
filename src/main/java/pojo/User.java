package pojo;

import lombok.Data;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/7/22 09:54
 * @Description: User
 * @Version 1.0.0
 */
@Data
public class User {
    private int age;
    private String name;
    public User(){

    }
    public User(int age,String name){
        this.age = age;
        this.name = name;
    }
}
