package com.diao.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: DataStructure
 * @description: 快速排序
 * @author: Mr.diao
 * @create: 2019-06-24 13:11
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        int[] arr = new int[9];
//        for (int i = 0; i < 9; i++) {
//            arr[i] = (int) (Math.random() * 80000);
//        }
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
        quickSort(arr, 0, arr.length - 1);

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr:
     * @param left:左边起点下标
     * @param right:右边起点下标
     * @Author: dyh
     * @Description: 快排
     * @Date: 2019/6/24
     * @Return:
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];//中心点
        int temp = 0;

        while (l < r) {
            //在中心左边找到比中心值大的值则跳出本次循环
            while (arr[l] < pivot) {
                l++;
            }
            //在中心右边找到比中心值小的值则跳出本次循环
            while (arr[r] > pivot) {
                r--;
            }
            //左标超过了右标，则跳出循环
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            /*if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }*/
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
