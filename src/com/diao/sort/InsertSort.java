package com.diao.sort;

import java.util.Arrays;

/**
 * @program: DataStructure
 * @description: 插入排序
 * @author: Mr.diao
 * @create: 2019-06-23 10:52
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arrs = {12, -13, 23, -24, 5};
        insertSort(arrs);
    }

    //插入排序
    public static void insertSort(int[] arrs) {
        int insertVal = 0;//待插入的数
        int insertIndex = 0;//待插入的数的下标-1
        for (int i = 1; i < arrs.length; i++) {
            insertVal = arrs[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arrs[insertIndex]) {
                arrs[insertIndex + 1] = arrs[insertIndex];
                insertIndex--;
            }

            arrs[insertIndex + 1] = insertVal;
            System.out.println("第" + (i) + "趟插入：" + Arrays.toString(arrs));
        }
    }
}
