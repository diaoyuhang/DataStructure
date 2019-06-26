package com.diao.hashtab;

/**
 * @program: DataStructure
 * @description: 员工链表
 * @author: Mr.diao
 * @create: 2019-06-26 15:01
 **/
public class EmployeeList {

    public Employee head;

    //添加新员工
    public void add(Employee employee) {
        if (head != null && head.getId() >= employee.getId()) {
            employee.next = head;
            head = employee;
            return;
        }
        if (head == null) {
            head = employee;
            return;
        }
        Employee temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = employee;
                break;
            }
            if (temp.next.getId() >= employee.getId()) {
                employee.next = temp.next;
                temp.next = employee;
                break;
            }

            temp = temp.next;
        }
    }

    //显示该链表中所有的员工
    public void list() {
        if (head == null) {
            System.out.println("该链表为空~~");
            return;
        }
        Employee temp = head;

        while (true) {
            System.out.printf("id=%d name%s\t", temp.getId(), temp.getName());

            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
