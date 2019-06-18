package com.diao.linkedList.interview;

import com.diao.linkedList.HeroNode;
import com.diao.linkedList.SingleLinkedList;

import java.util.Stack;

/**
 * @program: DataStructure
 * @description: 单链表面试题
 * @author: Mr.diao
 * @create: 2019-06-18 13:55
 **/
public class LinkedListInterview {

    /**
     * @param list: 单链表
     * @Author: dyh
     * @Description: 求链表的长度
     * @Date: 2019/6/18
     * @Return:
     */
    public static int getLength(SingleLinkedList list) {
        HeroNode head = list.head;
        HeroNode temp = head;

        int length = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * @param list:  单链表
     * @param index: 倒数第几个数
     * @Author: dyh
     * @Description: 查找倒数第几个结点
     * @Date: 2019/6/18
     * @Return:
     */
    public static HeroNode findLastIndexNode(SingleLinkedList list, int index) {

        int length = getLength(list);
        HeroNode temp = list.head.next;

        if (list.head.next == null) {
            return null;//没找到
        }
        if (index <= 0 || index > length) {
            return null;
        }

        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * @param list: 单链表
     * @Author: dyh
     * @Description: 单链表的反转
     * @Date: 2019/6/18
     * @Return:
     */
    public static void reversetList(SingleLinkedList list) {
        HeroNode head = list.head;
        HeroNode reverHead = new HeroNode(0, "", "");

        if (head.next == null) {
            return;
        }

        HeroNode curr = head.next;
        HeroNode temp = null;
        while (true) {

            if (curr == null) {
                break;
            }
            temp = curr;
            curr = curr.next;
            temp.next = reverHead.next;
            reverHead.next = temp;
        }

        head.next = reverHead.next;
    }

    /**
     * @param list:
     * @Author: dyh
     * @Description: 反向打印链表
     * @Date: 2019/6/18
     * @Return:
     */
    public static void reverPrint(SingleLinkedList list) {
        HeroNode temp = list.head;

        if (temp.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        while (true) {
            if (temp.next == null) {
                break;
            }
            stack.push(temp.next);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * @param list1: 单链表1
     * @param list2: 单链表2
     * @Author: dyh
     * @Description: 两个有序单链表合并
     * @Date: 2019/6/18
     * @Return:
     */
    public static SingleLinkedList merge2LinkedList(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedList newlist = new SingleLinkedList();
        HeroNode head1 = list1.head;
        HeroNode head2 = list2.head;
        HeroNode newhead = newlist.head;

        HeroNode curr1 = head1.next;
        HeroNode curr2 = head2.next;
//        HeroNode temp1 = null;
//        HeroNode temp2 = null;

        HeroNode temp = newhead;
        while (true) {
            if (head1.next == null && head2.next == null) {
                break;
            }

            if ((curr1 == null && curr2 != null) || (curr1 != null && curr2 == null)) {
                if (curr1 == null) {

                    while (true) {
                        if (curr2 == null) {
                            break;
                        }
                        temp.next = curr2;
                        temp = temp.next;
                        curr2 = curr2.next;
                    }

                } else {
                    while (true) {
                        if (curr1 == null) {
                            break;
                        }
                        temp.next = curr1;
                        temp = temp.next;
                        curr1 = curr1.next;
                    }
                }
                break;
            }

            if (curr1.no < curr2.no) {
                temp.next = curr1;
                temp = temp.next;
                curr1 = curr1.next;
            } else {
                temp.next = curr2;
                temp = temp.next;
                curr2 = curr2.next;
            }
        }

        return newlist;
    }
}
