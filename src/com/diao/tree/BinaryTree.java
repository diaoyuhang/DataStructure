package com.diao.tree;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-27 10:20
 **/
public class BinaryTree {

    private HeroNode root;

    public BinaryTree() {
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int id) {
        if (root != null) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        }

    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        return root.postOrderSearch(id);
    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {
        return root.infixOrderSearch(id);
    }

    //前序查找
    public HeroNode preOrderSearch(int id) {
        return root.preOrderSearch(id);
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空~~");
        }

    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }

    }

    //前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空~~");
        }
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}
