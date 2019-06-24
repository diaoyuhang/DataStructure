package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 希尔排序
 * @author: Mr.diao
 * @create: 2019-06-24 10:24
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arr) {
        int j = 0;
        int temp = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//求算出每趟的步长
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];

                if (temp < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环
                    arr[j] = temp;
                }
            }

        }

    }
}
