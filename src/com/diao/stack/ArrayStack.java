package com.diao.stack;

/**
 * @program: DataStructure
 * @description: 数组模拟栈
 * @author: Mr.diao
 * @create: 2019-06-20 10:44
 **/
public class ArrayStack {
    private int top = -1;
    private int maxSize;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是否为空
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {

        if (isFull()) {
            System.out.println("栈数据已满！");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return stack[top--];
    }

    //展示栈中的所有的数据
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //查看顶部的元素
    public void head() {
        if (isEmpty()) {
            throw new RuntimeException("栈数据为空");
        }
        System.out.printf("stack[%d]=%d\n",top, stack[top]);

    }
}
