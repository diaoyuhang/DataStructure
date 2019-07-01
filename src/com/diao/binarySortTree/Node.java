package com.diao.binarySortTree;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-07-01 15:01
 **/
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    /**
     * @param value:
     * @Author: dyh
     * @Description: 查找结点
     * @Date: 2019/7/1
     * @Return:
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * @param value:
     * @Author: dyh
     * @Description: 返回要删除的结点的父节点
     * @Date: 2019/7/1
     * @Return:
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//没有找到父节点
            }
        }

    }


    //中序遍历二叉排序树
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    //递归添加二叉排序树结点
    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
