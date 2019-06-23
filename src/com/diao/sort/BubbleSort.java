package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 冒泡排序
 * @author: Mr.diao
 * @create: 2019-06-23 10:23
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrs = {-2, 13, 23, 24, 25};
        bubbleSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    //冒泡排序
    public static void bubbleSort(int[] arrs) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arrs.length - 1; i++) {//总共排多少趟
            //一趟排序
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    flag = true;
                    temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "趟排序:" + Arrays.toString(arrs));
        }
    }
}
