package com.diao.linkedList;

/**
 * @program: DataStructure
 * @description: 单向链表
 * @author: Mr.diao
 * @create: 2019-06-18 10:26
 **/
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    /**
     * @param node: 新节点
     * @Author: dyh
     * @Description: 添加结点，不排序
     * @Date: 2019/6/18
     * @Return:
     */
    public void add(HeroNode node) {
        //因为头结点不能够移动，所以创建一个辅助结点用于遍历
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * @param node: 新节点
     * @Author: dyh
     * @Description: 有序添加结点
     * @Date: 2019/6/18
     * @Return:
     */
    public void addByOrder(HeroNode node) {

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;//标识已存在该值
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            System.out.printf("编号已经存在%d，不能插入\n", node.no);
        } else {
            //插入到链表，在temp后面
            node.next = temp.next;
            temp.next = node;
        }

    }

    /**
     * @param node:需修改的结点
     * @Author: dyh
     * @Description: 根据结点修改信息
     * @Date: 2019/6/18
     * @Return:
     */
    public void update(HeroNode node) {
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点

        while (true) {
            if (temp == null) {
                break;//表示没有找到该节点
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号%d的结点\n", node.no);
        }
    }


    /**
     * @Author: dyh
     * @Description: 显示链表的数据
     * @Date: 2019/6/18
     * @Return:
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //创建一个辅助结点
        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            //输出结点
            System.out.println(temp);
//            将辅助结点后移，指向下一个节点
            temp = temp.next;
        }
    }

    /**
     * @param no: 节点序号
     * @Author: dyh
     * @Description: 删除节点
     * @Date: 2019/6/18
     * @Return:
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {

            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在\n", no);
        }

    }
}
