package com.diao.search;

/**
 * @program: DataStructure
 * @description: 插值查找
 * @author: Mr.diao
 * @create: 2019-06-25 13:48
 **/
public class insertValueSearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertSearch(arr, 0, arr.length - 1, 10);
        System.out.println(index);
    }

    public static int insertSearch(int[] arr, int left, int right, int findValue) {

        //这里一定要判断，不然下面的的mid可能就会越界
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return -1;
        }

        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue) {
            return insertSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return insertSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
