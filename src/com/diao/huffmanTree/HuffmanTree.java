package com.diao.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: DataStructure
 * @description: 赫夫曼树
 * @author: Mr.diao
 * @create: 2019-06-29 13:43
 **/
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    //先序遍历
    public static void preOrder(Node root) {
        System.out.println(root);
        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }
    }

    /**
     * @param arr:
     * @Author: dyh
     * @Description: 创建赫夫曼树
     * @Date: 2019/6/29
     * @Return:
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int a : arr) {
            list.add(new Node(a));
        }
        while (list.size() > 1) {
            Collections.sort(list);

            Node node1 = list.get(0);
            Node node2 = list.get(1);

            Node newNode = new Node(node1.getValue() + node2.getValue());
            newNode.setLeft(node1);
            newNode.setRight(node2);

            list.remove(node1);
            list.remove(node2);
            list.add(newNode);
        }
        return list.get(0);
    }
}
