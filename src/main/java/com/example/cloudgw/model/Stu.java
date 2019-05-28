package com.example.cloudgw.model;

import java.io.Serializable;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 18:43
 */
public class Stu implements Serializable {

    private String name;
    private Integer age;

    public Stu() {
    }

    public Stu(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
