package com.diao.stack.linkedStack;

import java.util.Scanner;

/**
 * @program: DataStructure
 * @description: 测试链表实现栈
 * @author: Mr.diao
 * @create: 2019-06-20 13:38
 **/
public class DoubleLinkedNodeDemo {


    public static void main(String[] args) {
        DoubleLinkedStack stack = new DoubleLinkedStack();

        Scanner scanner = new Scanner(System.in);
        String key = "";

        boolean flag = true;
        while (flag) {
            System.out.println("a:显示栈");
            System.out.println("b:入栈");
            System.out.println("c:出栈");
            System.out.println("d:退出");

            key = scanner.nextLine();
            switch (key) {
                case "a":
                    stack.list();
                    break;
                case "b":
                    int num = scanner.nextInt();
                    DoubleLinkedNode node1 = new DoubleLinkedNode(num);

                    stack.push(node1);
                    break;
                case "c":
                    DoubleLinkedNode node = stack.pop();
                    System.out.println(node);
                    break;
                case "d":
                    flag = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }
}
