package com.diao.stack.calculator;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-20 14:08
 **/
public class Calculator {
    public static void main(String[] args) {
        String expression = "77*277*3-5+1+3-4";

        ArrayStack stack1 = new ArrayStack(10);
        ArrayStack stack2 = new ArrayStack(10);

        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;

        int oper = 0;
        int res = 0;

        String keepnum = "";//用于拼接多位

        char ch;
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);

            //判断是不是符号
            if (stack2.isOper(ch)) {
                //判断符号栈是否空
                if (stack2.isEmpty()) {
                    stack2.push(ch);
                } else {
                    //判断当符号优先级是不是小于等于符号栈中栈顶符号
                    if (stack2.priority(ch) <= stack2.priority(stack2.peek())) {

                        oper = stack2.pop();
                        num1 = stack1.pop();
                        num2 = stack1.pop();
                        res = stack2.cal(num1, num2, oper);

                        stack1.push(res);//将运算结果压入数值栈中

                        stack2.push(ch);//将符号压入符号栈
                    } else {
                        stack2.push(ch);
                    }

                }
            } else {
                //处理多位数
                keepnum += ch;
                if (index == expression.length() - 1) {
                    stack1.push(Integer.parseInt(keepnum));
                } else {

                    //判断后一位是不是符号位
                    if (stack2.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符就直接将前面的数值压入数值栈
                        stack1.push(Integer.parseInt(keepnum));

                        //清空数值
                        keepnum = "";
                    }
                }
            }
            index++;
            //判断是不是扫描到了最后一位
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {

            if (stack2.isEmpty()) {
                break;
            }

            oper = stack2.pop();
            num1 = stack1.pop();
            num2 = stack1.pop();
            res = stack2.cal(num1, num2, oper);

            stack1.push(res);
        }

        System.out.printf("表达式%s=%d", expression, stack1.pop());
    }
}
