package com.diao.huffmanCode;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-30 14:01
 **/
public class Node implements Comparable<Node> {
    Byte data;//存放字符本身的数据
    int weight;//权值大小，存放字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;

    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
