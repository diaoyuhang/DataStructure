package com.diao.hashtab;

/**
 * @program: DataStructure
 * @description: 员工实体类
 * @author: Mr.diao
 * @create: 2019-06-26 14:58
 **/
public class Employee {
    private int id;
    private String name;
    public Employee next;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
