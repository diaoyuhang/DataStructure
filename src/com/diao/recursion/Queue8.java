package com.diao.recursion;


/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-22 14:24
 **/
public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    private static int count = 0;

    public static void main(String[] args) {
        //用一个一维数组来表示棋盘上的棋子位置，下标表示第几个棋子，下标对应的值表示第几列
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d结果", count);
    }

    public void check(int n) {
        if (n == max) {
            count++;
            show();
            return;
        }

        for (int i = 0; i < max; i++) {
            //把第n个皇后放入第一列
            array[n] = i;
            //判断当前皇后与之前的皇后位置是否发生冲突
            if (judge(n)) {
                check(n + 1);
            }
            //如果发生冲突，继续往下执行，将第n个皇后放入第i+1个列中
        }
    }

    /**
     * @param n: 第几个皇后
     * @Author: dyh
     * @Description: 判断与之前的皇后摆放的位置是否发生冲突
     * @Date: 2019/6/22
     * @Return:
     */
    public boolean judge(int n) {

        for (int i = 0; i < n; i++) {

            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Author: dyh
     * @Description: 输出皇后的位置
     * @Date: 2019/6/22
     * @Return:
     */
    public void show() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
