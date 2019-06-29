package com.diao.tree;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 堆排序
 * @author: Mr.diao
 * @create: 2019-06-29 10:34
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        ////将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

//        2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
//　　	3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }

    }

    /**
     * @param arr:            数组
     * @param i:表示非叶子结点在数组中索引
     * @param length:         数组的长度
     * @Author: dyh
     * @Description: 讲一个数组（二叉树），调整成大顶堆
     * @Date: 2019/6/29
     * @Return:
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            //如果右节点大于左节点，则k++
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                //！！！需要继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束后，将以i为父节点的树的最大值，调整到最前面，将i这个值调整到后面
        arr[i] = temp;
    }
}
