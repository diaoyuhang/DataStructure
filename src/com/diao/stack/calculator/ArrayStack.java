package com.diao.stack.calculator;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-20 14:08
 **/
public class ArrayStack {

    public int maxSize;
    public int[] stack;
    public int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是否空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断是否满
    public boolean isFull() {
        return top == maxSize - 1;

    }

    //展示栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i++) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //入栈
    public void push(int num) {

        if (isFull()) {
            System.out.println("栈已满~~");
            return;
        }

        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //查案顶部元素
    public int peek() {
        return stack[top];
    }

    //返回操作符的优先级
    public int priority(int opertion) {
        if (opertion == '*' || opertion == '/') {
            return 1;
        } else if (opertion == '+' || opertion == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个操作符
    public boolean isOper(char val) {

        return val == '+' || val == '-' || val == '/' || val == '*';
    }

    //计算
    public int cal(int num1, int num2, int oper) {

        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
