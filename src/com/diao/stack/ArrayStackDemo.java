package com.diao.stack;

import java.util.Scanner;

/**
 * @program: DataStructure
 * @description: 数组栈测试
 * @author: Mr.diao
 * @create: 2019-06-20 11:04
 **/
public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
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
                    arrayStack.list();
                    break;
                case "b":
                    int num = scanner.nextInt();
                    arrayStack.push(num);
                    break;
                case "c":
                    int nm = arrayStack.pop();
                    System.out.println(nm);
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
