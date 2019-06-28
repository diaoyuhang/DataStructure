package com.diao.tree;

/**
 * @program: DataStructure
 * @description: 顺序存储二叉树
 * @author: Mr.diao
 * @create: 2019-06-28 13:48
 **/
public class ArrBinaryTree {

    private int[] arr = null;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //后序遍历的重载
    public void postOrder() {
        this.postOrder(0);
    }

    //顺序存储二叉树后序遍历
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树不能为空");
            return;
        }

        if ((2 * index + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);

    }


    //中序遍历的重载
    public void infixOrder() {
        this.infixOrder(0);
    }

    //顺序存储二叉树中序遍历
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树不能为空");
            return;
        }
        if ((2 * index + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);

        if ((2 * index + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }


    //重载
    public void preOrder() {
        this.preOrder(0);
    }

    //顺序存储二叉树的前序遍历
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("二叉树不能为空");
            return;
        }

        System.out.println(arr[index]);

        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }

        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }

    }


    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
