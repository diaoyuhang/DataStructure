package com.diao.avl;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-07-02 10:06
 **/
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //右旋转
    public void rightRotate() {
        //创建一个新节点，值为当前节点的值
        Node newNode = new Node(value);
        //把新结点的右子树设置为当前节点的右子树
        newNode.right = this.right;
        //把新结点的左子树设置为当前节点的左子树的右子树
        newNode.left = this.left.right;
        //把当前节点的值设置为左子节点值
        this.value = this.left.value;
        //把当前节点的左子树设置为左子树的左子树
        this.left = this.left.left;
        //把当前节点的右子树设置为新结点
        this.right = newNode;

    }

    //左旋转
    public void leftRotate() {
        //创建一个新的结点，值为当前根节点的值
        Node newNode = new Node(value);
        //把新结点的左子树设置为当前节点的左子树
        newNode.left = this.left;
        //把新结点的右子树设置为当前节点的右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值更换为右子节点的值
        this.value = this.right.value;
        //把当前节点的右子树设置为右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子树设置为新结点
        this.left = newNode;

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
        //右子树的高度-左子树的高度大于1
        if (rightHeight() - leftHeight() > 1) {
            //右子树的左子树高度大于右子树的右子树高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先进右子树的右旋转
                right.rightRotate();
                //左旋转
                leftRotate();
            } else {
                leftRotate();
            }
            //这里必须要return，如果这里二叉树已经平衡过，所以下面就不需要执行，否则会造成二叉树的变动
            return;
        }

        //左子树的高度-右子树高度大于1
        if (leftHeight() - rightHeight() > 1) {
            //左子树的右子树高度大于左子树的左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //左子树的左旋转
                left.leftRotate();
                //当前节点的右旋转
                rightRotate();
            }else {
                rightRotate();
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
