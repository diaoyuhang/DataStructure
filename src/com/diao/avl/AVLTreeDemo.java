package com.diao.avl;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-07-02 10:22
 **/
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr={10,12,8,9,7,6};
       int[] arr={10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("未旋转前：");
        avlTree.infix();
        System.out.println("二叉树的高度为：" + avlTree.root.height());
        System.out.println("二叉树的左子树高度：" + avlTree.root.leftHeight());
        System.out.println("二叉树的右子树高度：" + avlTree.root.rightHeight());
        System.out.println("旋转后：");

//        avlTree.rightRotate();
//
//        avlTree.infix();
//        System.out.println("二叉树的高度为：" + avlTree.root.height());
//        System.out.println("二叉树的左子树高度：" + avlTree.root.leftHeight());
//        System.out.println("二叉树的右子树高度：" + avlTree.root.rightHeight());
    }
}
