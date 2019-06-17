package com.diao.queue;

import java.util.Scanner;

/**
 * @program: DataStructure
 * @description: 环形队列
 * @author: Mr.diao
 * @create: 2019-06-17 16:25
 **/
public class AnnualQueue {

    private int maxSize;
    private int[] arr;
    private int front = 0;
    private int rear = 0;

    public AnnualQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public static void main(String[] args) {
        AnnualQueue queue = new AnnualQueue(4);
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
        System.out.println("程序退出！");
    }

    /**
     * @Author: dyh
     * @Description: 判断是否满
     * @Date: 2019/6/17
     * @Return:
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
     * @param num:
     * @Author: dyh
     * @Description: 添加元素
     * @Date: 2019/6/17
     * @Return:
     */
    public void addQueue(int num) {

        if (isFull()) {
            System.out.println("队列已经满了！");
            return;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    /**
     * @Author: dyh
     * @Description: 出队，获取第一个元素
     * @Date: 2019/6/17
     * @Return:
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        int num = arr[front];
        front = (front + 1) % maxSize;
        return num;
    }

    /**
     * @Author: dyh
     * @Description: 显示队列
     * @Date: 2019/6/17
     * @Return:
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * @Author: dyh
     * @Description: 队列中实际的存储数据的长度
     * @Date: 2019/6/17
     * @Return:
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * @Author: dyh
     * @Description: 显示队列的头数据
     * @Date: 2019/6/17
     * @Return:
     */
    public int headQueue() {
        return arr[front];
    }
}
