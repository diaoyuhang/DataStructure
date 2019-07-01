package com.diao.binarySortTree;

/**
 * @program: DataStructure
 * @description: 二叉排序树
 * @author: Mr.diao
 * @create: 2019-07-01 15:08
 **/
public class BinarySortTree {

    private Node root;

    public void infix() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        root.infixOrder();
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        //查找要删除的节点
        Node targetNode = search(value);
        if (targetNode == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        //查找要删除节点的父节点
        Node parentNode = searchParent(value);
        if (targetNode.left == null && targetNode.right == null) {
            if (parentNode.left != null && parentNode.left.value == value) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right.value == value) {
                parentNode.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {//有两个子树
            int minValue = delRightTreeMin(targetNode);
            targetNode.value = minValue;
        } else {//只有一个子树
            if (targetNode.left != null) {
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                }
            } else {
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }

        }

    }

    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        //删除最小节点
        delNode(target.value);
        return target.value;
    }

    //查找结点
    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    //添加新节点
    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }
}
