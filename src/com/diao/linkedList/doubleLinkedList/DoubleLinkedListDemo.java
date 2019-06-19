package com.diao.linkedList.doubleLinkedList;

/**
 * @program: DataStructure
 * @description: 测试双向链表
 * @author: Mr.diao
 * @create: 2019-06-19 10:34
 **/
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list=new DoubleLinkedList();

        list.addByOrder(new HeroNode(1, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(4, "林冲", "豹子头"));
        list.addByOrder(new HeroNode(3, "卢俊义", "玉麒麟"));
        list.addByOrder(new HeroNode(2, "吴用", "智多星"));

        list.list();

        list.update(new HeroNode(1, "日你妹", "及时雨"));
        list.del(4);
        list.list();
    }
}
