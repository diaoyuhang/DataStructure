package com.diao.stack.linkedStack;

/**
 * @program: DataStructure
 * @description: 链表实现栈
 * @author: Mr.diao
 * @create: 2019-06-20 13:22
 **/
public class DoubleLinkedStack {

    public DoubleLinkedNode head = new DoubleLinkedNode(0);

    //入栈
    public void push(DoubleLinkedNode node) {
        node.next = head.next;
        if (head.next != null) {
            head.next.pre = node;
        }

        head.next = node;
        node.pre = head;
    }

    //展示栈中的元素
    public void list() {
        if (head.next == null) {
            System.out.println("栈为空~~");
            return;
        }

        DoubleLinkedNode temp = head.next;
        while (true) {

            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //出栈
    public DoubleLinkedNode pop() {

        if (head.next == null) {
            System.out.println("栈为空");
            return null;
        }
        DoubleLinkedNode node = head.next;

        head.next = node.next;
        if (node.next != null) {
            node.next.pre = head;
        }

        return node;
    }

}
