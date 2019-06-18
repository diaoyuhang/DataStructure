package com.diao.linkedList;

/**
 * @program: DataStructure
 * @description: 单向链表的测试
 * @author: Mr.diao
 * @create: 2019-06-18 10:22
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.addByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        list.addByOrder(new HeroNode(1,"宋江","及时雨"));
        list.addByOrder(new HeroNode(4,"吴用","智多星"));
        list.addByOrder(new HeroNode(3,"林冲","豹子头"));

        list.del(4);
        list.del(1);
        list.del(9);

        list.list();
    }
}
