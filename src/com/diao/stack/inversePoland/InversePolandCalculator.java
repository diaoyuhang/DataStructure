package com.diao.stack.inversePoland;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: DataStructure
 * @description: 逆波兰表达式
 * @author: Mr.diao
 * @create: 2019-06-21 14:06
 **/
public class InversePolandCalculator {

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> list = infixExpressionToList(expression);
        System.out.println("中缀：" + list);
        List<String> suffixExpression = parseSuffixExpressionToList(list);
        System.out.println("后缀：" + suffixExpression);
        int result = calculate(suffixExpression);
        System.out.println(result);

    }

    /**
     * @param list: 中缀list
     * @Author: dyh
     * @Description: 将中缀表达式转换成后缀表达式
     * @Date: 2019/6/21
     * @Return:
     */
    public static List<String> parseSuffixExpressionToList(List<String> list) {
        Stack<String> stack1 = new Stack<>();
        List<String> list1 = new ArrayList<>();

        for (String str : list) {

            if (str.matches("\\d+")) {
                list1.add(str);
            } else if (str.equals("(")) {
                stack1.add(str);
            } else if (str.equals(")")) {
                //如果是右括号“)”，则依次弹出stack1栈顶的运算符，并压入list1，直到遇到左括号为止，此时将这一对括号丢弃
                while (!stack1.peek().equals("(")) {
                    list1.add(stack1.pop());
                }
                stack1.pop();
            } else {
                while (stack1.size() > 0 && getValue(stack1.peek()) >= getValue(str)) {
                    list1.add(stack1.pop());
                }
                stack1.push(str);
            }
        }
        while(stack1.size()>0){
            list1.add(stack1.pop());
        }
        return list1;
    }

    //获取运算符的优先级
    public static int getValue(String operation) {
        int ADD = 1;
        int SUB = 1;
        int MUL = 2;
        int DIV = 2;

        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

    /**
     * @param expression: 计算式
     * @Author: dyh
     * @Description: 将表达式转换成list返回
     * @Date: 2019/6/21
     * @Return:
     */
    public static List<String> infixExpressionToList(String expression) {

        List<String> list = new ArrayList<>();
        String str = "";//用来拼接多位数
        char c;
        int index = 0;//指针

        while (index < expression.length()) {
            //字符数字的ASCII值48~57
            if ((c = expression.charAt(index)) < 48 || (c = expression.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {

                str = "";
                while ((index < expression.length()) && (c = expression.charAt(index)) >= 48 && (c = expression.charAt(index)) <= 57) {
                    str += c;
                    index++;
                }
                list.add(str);
            }
        }

        return list;
    }


    /**
     * @param suffixExpression: 后缀表达式
     * @Author: dyh
     * @Description: 将后缀表达式依次放入list集合中
     * @Date: 2019/6/21
     * @Return:
     */
    public static List<String> getListString(String suffixExpression) {

        String[] splits = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();

        for (String str : splits) {
            list.add(str);
        }
        return list;
    }

    /**
     * @param list:
     * @Author: dyh
     * @Description: 根据后缀表达式计算结果
     * @Date: 2019/6/21
     * @Return:
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();

        for (String str : list) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (str) {
                    case "+":
                        res = num2 + num1;

                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        System.out.println("错误的运算符");
                        break;
                }
                stack.push(res + "");
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
