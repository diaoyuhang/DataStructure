package com.diao.binarySortTree;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-07-01 15:11
 **/
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int a : arr) {
            binarySortTree.add(new Node(a));
        }
       // binarySortTree.infix();

        binarySortTree.delNode(7);
        binarySortTree.infix();
        //System.out.println(binarySortTree.searchParent(3));
    }
}
