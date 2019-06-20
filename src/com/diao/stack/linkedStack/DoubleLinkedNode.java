package com.diao.stack.linkedStack;

/**
 * @program: DataStructure
 * @description: 链表实现栈的结点
 * @author: Mr.diao
 * @create: 2019-06-20 13:14
 **/
public class DoubleLinkedNode {

    public int num;
    public DoubleLinkedNode next = null;
    public DoubleLinkedNode pre = null;

    public DoubleLinkedNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "num=" + num +
                '}';
    }
}
