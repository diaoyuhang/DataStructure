package com.diao.tree;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-27 10:22
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
//先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("删除前：");
        binaryTree.preOrder();
        binaryTree.delNode(11);

        System.out.println("删除后");
        binaryTree.preOrder();

//        binaryTree.preOrder();
//        System.out.println("===========================");
//        binaryTree.infixOrder();
//        System.out.println("===========================");
//        binaryTree.postOrder();
//        HeroNode heroNode = binaryTree.preOrderSearch(1);
//        HeroNode heroNode = binaryTree.infixOrderSearch(3);
//        HeroNode heroNode = binaryTree.postOrderSearch(4);
//        System.out.println(heroNode);

    }
}
