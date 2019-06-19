package com.diao.linkedList.Josephu;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-19 11:05
 **/
public class CircleSingleLinkedList {

    //创建一个变量指针
    private Boy first = null;

    public void addBoy(int num) {

        if (num < 1) {
            System.out.println("不能小于1");
            return;
        }
        Boy curr = null;

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;//构成环形
                curr = first;//让curr指向第一个节点
            } else {
                curr.next = boy;
                curr = boy;
                curr.next = first;
            }

        }
    }

    /**
     * @Author: dyh
     * @Description: 显示循环队列
     * @Date: 2019/6/19
     * @Return:
     */
    public void showBoy() {

        if (first == null) {
            System.out.println("队列为空");
            return;
        }
        Boy curr = first;

        while (true) {

            System.out.println(curr);
            if (curr.next == first) {
                break;
            }
            curr = curr.next;
        }
    }

    /**
     * @param startNo:  从第几个开始
     * @param countNum: 数几下
     * @param nums:     总个数
     * @Author: dyh
     * @Description: 计算出圈顺序
     * @Date: 2019/6/19
     * @Return:
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null) {
            System.out.println("队列为空");
            return;
        }
        if (startNo < 1 || startNo > nums) {
            System.out.println("输入有误!");
            return;
        }
        //创建辅助结点，帮助完成结点出圈
        Boy end = first;

        //将end指向最后一个结点
        while (true) {
            if (end.next == first) {
                break;
            }
            end = end.next;
        }
        //移动到起始点
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            end = end.next;
        }

        while (true) {

            if (end == first) {//说明循环队列中只有一个结点了
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                end = end.next;
            }
            //这时first指向的就是要出去的结点
            System.out.println(first);
            end.next = first.next;
            first=first.next;
        }

        System.out.println(first);
    }
}
