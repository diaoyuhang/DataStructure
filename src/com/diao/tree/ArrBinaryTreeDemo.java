package com.diao.tree;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-28 13:57
 **/
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);

        binaryTree.postOrder();

    }
}
