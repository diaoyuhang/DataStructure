package com.diao.queue;

import java.util.Scanner;

/**
 * @program: DataStructure
 * @description: 数组实现队列
 * @author: Mr.diao
 * @create: 2019-06-17 13:58
 **/
public class ArrayQueue {

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = -1;
        front = -1;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):显示队列中第一个数据");
            char key = scanner.next().charAt(0);

            switch (key) {

                case 's':
                    queue.showQueue();

                    break;
                case 'e':
                    flag = false;
                    scanner.close();
                    break;
                case 'a':
                    int num = scanner.nextInt();
                    queue.addQueue(num);

                    break;
                case 'g':
                    try {
                        int i = queue.getQueue();
                        System.out.println(i);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    System.out.println(queue.headQueue());
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

    /**
     * @Author: dyh
     * @Description: 判断是否满
     * @Date: 2019/6/17
     * @Return:
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * @Author: dyh
     * @Description: 判断是否为空
     * @Date: 2019/6/17
     * @Return:
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * @Author: dyh
     * @Description: 添加数据到队列
     * @Date: 2019/6/17
     * @Return:
     */
    public void addQueue(int num) {
        //判断是否已满
        if (isFull()) {
            System.out.println("队列已经满了！");
            return;
        }

        rear++;
        arr[rear] = num;
    }

    /**
     * @Author: dyh
     * @Description: 出队，获取队列中的第一个元素
     * @Date: 2019/6/17
     * @Return:
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    /**
     * @Author: dyh
     * @Description: 显示队列中的所有数据
     * @Date: 2019/6/17
     * @Return:
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * @Author: dyh
     * @Description: 显示队列的头数据
     * @Date: 2019/6/17
     * @Return:
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列没有数据！");
        }
        return arr[front + 1];
    }
}
