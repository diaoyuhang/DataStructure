package com.diao.linkedList.doubleLinkedList;

/**
 * @program: DataStructure
 * @description: 链表结点
 * @author: Mr.diao
 * @create: 2019-06-19 10:00
 **/
public class HeroNode {

    public int no;
    public String name;
    public String nickName;

    public HeroNode pre;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
