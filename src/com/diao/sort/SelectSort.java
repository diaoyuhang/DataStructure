package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 选择排序
 * @author: Mr.diao
 * @create: 2019-06-23 10:39
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arrs = {12, -13, 23, -24, 5};
        selectSort(arrs);
    }

    //选择排序
    public static void selectSort(int[] arrs) {
        int min = 0;//记录最小值
        int minIndex = 0;//记录最小值的下标

        for (int i = 0; i < arrs.length - 1; i++) {
            min = arrs[i];
            minIndex = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (min > arrs[j]) {
                    min = arrs[j];
                    minIndex = j;
                }
            }

            arrs[minIndex] = arrs[i];
            arrs[i] = min;
            System.out.println("第" + (i + 1) + "次排序的结果：" + Arrays.toString(arrs));
        }
    }
}
