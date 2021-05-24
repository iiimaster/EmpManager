package com.mryang.model;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName Emp.java
 * @Description TODO 领域模型：员工类 pojo
 * @createTime 2021年05月17日 21:35:00
 */

public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private Double salary;

    public Emp() {
    }

    public Emp(String name, Integer age, Integer sex, Double salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public Emp(Integer id, String name, Integer age, Integer sex, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() { // Json格式的toString()
        return '{' +
                "\"id\":" + id +
                ",\"name\":" +"\""+ name +"\""+
                ",\"age\":" + age +
                ",\"sex\":" + sex +
                ",\"salary\":" + salary +
                '}';
    }
}
