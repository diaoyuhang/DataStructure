package com.diao.linkedList;

import com.diao.linkedList.interview.LinkedListInterview;

/**
 * @program: DataStructure
 * @description: 单向链表的测试
 * @author: Mr.diao
 * @create: 2019-06-18 10:22
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        int length = LinkedListInterview.getLength(list);

        list.addByOrder(new HeroNode(1, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(3, "林冲", "豹子头"));

        list2.addByOrder(new HeroNode(5, "卢俊义", "玉麒麟"));
        list2.addByOrder(new HeroNode(6, "宋江", "及时雨"));
        list2.addByOrder(new HeroNode(7, "吴用", "智多星"));
        list2.addByOrder(new HeroNode(8, "林冲", "豹子头"));

        SingleLinkedList merge2LinkedList = LinkedListInterview.merge2LinkedList(list, list2);
        merge2LinkedList.list();
    }
}
