package com.diao.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructure
 * @description: 二分查找
 * @author: Mr.diao
 * @create: 2019-06-25 11:52
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        // int index = binarySearch(arr, 0, arr.length - 1, 10);
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);

        System.out.println(list);
    }

    //二分查找
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //如果左指针大于右指针
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findVal > midValue) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return mid;
        }

    }

    //查找数组中有多个一样的数值，返回所有的数值的下标
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findVal > midValue) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp > 0 && arr[temp] == findVal) {
                    list.add(temp);
                    temp--;
                } else {
                    break;
                }
            }
            list.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp < arr.length - 1 && arr[temp] == findVal) {
                    list.add(temp);
                    temp++;
                } else {
                    break;
                }
            }

            return list;
        }
    }
}
