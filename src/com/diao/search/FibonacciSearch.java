package com.diao.search;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 斐波那契(黄金分割法)查找
 * @author: Mr.diao
 * @create: 2019-06-26 13:50
 **/
public class FibonacciSearch {

    int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 1234));

    }

    /**
     * @param arr:查找数组
     * @param key:需要查找的值
     * @Author: dyh
     * @Description: 斐波那契查找算法
     * @Date: 2019/6/26
     * @Return: 返回下标，没有就返回-1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int k = 0;//用来记录黄金分割点下标
        int mid = 0;
        int[] f = fib();

        //获取斐波那契分割点的下标
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k]的值可能大于arr的长度，因此需要构建一个新的数组temp，不足的部分用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);

        //实际上需求使用arr数组最后的数填充 temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = temp[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;

            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    //非递归方式创建一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[20];

        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
