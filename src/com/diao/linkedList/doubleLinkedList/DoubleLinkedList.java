package com.diao.linkedList.doubleLinkedList;

/**
 * @program: DataStructure
 * @description: 双向链表
 * @author: Mr.diao
 * @create: 2019-06-19 10:03
 **/
public class DoubleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * @Author: dyh
     * @Description: 遍历双向链表
     * @Date: 2019/6/19
     * @Return:
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * @param node: 新节点
     * @Author: dyh
     * @Description: 添加新节点（默认添加到最后）
     * @Date: 2019/6/19
     * @Return:
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * @param heroNode:
     * @Author: dyh
     * @Description: 修改内容
     * @Date: 2019/6/19
     * @Return:
     */
    public void update(HeroNode heroNode) {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到该节点%d", heroNode.no);
        }
    }

    /**
     * @param no:要删除节点的编号
     * @Author: dyh
     * @Description: 删除节点
     * @Date: 2019/6/19
     * @Return:
     */
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到要删除的节点%d", no);
        }
    }

    /**
     * @param node:新节点
     * @Author: dyh
     * @Description: 有序添加
     * @Date: 2019/6/19
     * @Return:
     */
    public void addByOrder(HeroNode node) {

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                flag = true;
                break;
            }
            if (temp.next.no > node.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            if (temp.next != null) {
                node.next = temp.next;
                temp.next.pre = node;
            }
            node.pre = temp;
            temp.next = node;
        } else {
            System.out.printf("编号已经存在%d", node.no);
        }
    }
}
