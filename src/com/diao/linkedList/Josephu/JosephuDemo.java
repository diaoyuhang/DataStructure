package com.diao.linkedList.Josephu;

/**
 * @program: DataStructure
 * @description: Josephu问题
 * @author: Mr.diao
 * @create: 2019-06-19 11:14
 **/
public class JosephuDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
        System.out.println("==================");
        list.countBoy(1, 2, 5);
    }
}
