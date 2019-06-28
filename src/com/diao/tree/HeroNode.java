package com.diao.tree;

/**
 * @program: DataStructure
 * @description: 二叉树节点
 * @author: Mr.diao
 * @create: 2019-06-27 10:01
 **/
public class HeroNode {

    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //删除节点
    public void delNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(id);
        }
        if (this.right != null) {
            this.right.delNode(id);
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;

        if (this.left != null) {
            resNode = this.left.postOrderSearch(id);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.id == id) {
            return this;
        }
        return resNode;

    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(id);
        }

        return resNode;
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.id == id) {
            return this;
        }

        if (this.left != null) {
            resNode = this.left.preOrderSearch(id);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(id);
        }
        return resNode;
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
