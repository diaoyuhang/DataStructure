package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 基数排序
 * @author: Mr.diao
 * @create: 2019-06-25 10:21
 **/
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    public static void radixSort(int[] arr) {
        //1、查到数组中最大的数值，并得到对应的有多少位
        int maxVAL = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVAL < arr[i]) {
                maxVAL = arr[i];
            }
        }
        int length = (maxVAL + "").length();//得到数值的位数


        //创建10个桶的二维数组
        int[][] bucket = new int[10][arr.length];

        //用来记录每个桶中的数据的个数
        int[] bucketElements = new int[10];

        for (int h = 0, n = 1; h < length; h++, n *= 10) {

            for (int i = 0; i < arr.length; i++) {
                int element = arr[i] / n % 10;//取出对应位的数字

                bucket[element][bucketElements[element]] = arr[i];
                bucketElements[element]++;
            }

            int index = 0;
            //遍历记录桶中的数值个数
            for (int j = 0; j < bucketElements.length; j++) {
                //如果这个桶中的数据个数不大于0，就直接跳到下一个桶中
                if (bucketElements[j] > 0) {
                    //循环将这个桶中的数值覆盖到原数组中
                    for (int k = 0; k < bucketElements[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //将记录的值重置为0
                bucketElements[j] = 0;
            }

        }

    }
}
