package com.diao.hashtab;

import com.diao.hashtab.EmployeeList;

/**
 * @program: DataStructure
 * @description: 员工哈希表
 * @author: Mr.diao
 * @create: 2019-06-26 15:32
 **/
public class HashTab {
    private EmployeeList[] table = null;
    private int size = 0;


    //初始化哈希表
    public HashTab(int size) {
        this.size = size;
        table = new EmployeeList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new EmployeeList();
        }
    }

    //添加新员工
    public void add(Employee employee) {
        int i = hashFun(employee.getId());
        table[i].add(employee);
    }

    //对整个哈希表进行遍历
    public void list() {
        for (int i = 0; i < table.length; i++) {
            table[i].list();
        }
    }

    //对员工id进行哈希
    public int hashFun(int id) {
        return id % size;
    }
}
