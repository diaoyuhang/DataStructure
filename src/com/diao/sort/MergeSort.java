package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 归并排序
 * @author: Mr.diao
 * @create: 2019-06-24 14:10
 **/
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2, 0};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+治
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }

    }

    //治
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;//初始化左边序列的初始索引
        int j = mid + 1;//初始化右边序列的初始索引
        int t = 0;//指向temp数组初始suoyin

        //1、将左右两边的数比较大小放入temp数组中，直到有一边结束
        while (i <= mid && j <= right) {//继续条件
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        //2、将有剩余数的一边全部填充到temp数组中
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp中的数全部拷贝到arr数组中
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            templeft++;
            t++;
        }
    }
}
