package com.diao.tree.threadedbinarytree;

/**
 * @program: DataStructure
 * @description: 线索二叉树
 * @author: Mr.diao
 * @create: 2019-06-28 14:36
 **/
public class Threadedbinarytree {

    private HeroNode node = null;
    //指向前驱结点
    private HeroNode pre = null;

    public void threadedNodesInfix() {
        pre = null;
        this.threadedNodesInfix(node);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        HeroNode root = node;

        while (root != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            while (root.getLeftType() == 0) {
                root = root.getLeft();
            }
            //打印当前这个结点
            System.out.println(root);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (root.getRightType() == 1) {
                root = root.getRight();
                System.out.println(root);
            }
//替换这个遍历的结点
            root = root.getRight();

        }

    }

    public void threadedNodesPost() {
        this.threadedNodesPost(node);
    }

    //二叉树进行后序线索化
    public void threadedNodesPost(HeroNode node) {
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNodesPost(node.getLeft());
        //线索化右子树
        threadedNodesPost(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

    //二叉树进行先序线索化重载
    public void threadedNodesPre() {
        this.pre = null;
        this.threadedNodesPre(node);
    }

    /**
     * @param node:
     * @Author: dyh
     * @Description: 编写对二叉树进行先序线索化的方法
     * @Date: 2019/6/28
     * @Return:
     */
    public void threadedNodesPre(HeroNode node) {
        if (node == null) {
            return;
        }

        //处理前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }


        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //线索化左子树
        if (node.getLeftType() != 1) {

            threadedNodesPre(node.getLeft());
        }
        //线索化右子树
        if (node.getRightType() != 1) {

            threadedNodesPre(node.getRight());
        }
    }


    /**
     * @Author: dyh
     * @Description: 编写对二叉树进行中序线索化的方法
     * @Date: 2019/6/28
     * @Return:
     */
    public void threadedNodesInfix(HeroNode node) {

        if (node == null) {
            System.out.println("根节点为空不能线索化");
            return;
        }
        //线索化左子树
        threadedNodesInfix(node.getLeft());
        //处理当前结点的前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //线索化右子树
        threadedNodesInfix(node.getRight());
    }

    public HeroNode getNode() {
        return node;
    }

    public void setNode(HeroNode root) {
        this.node = root;
    }
}
