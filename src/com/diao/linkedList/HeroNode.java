package com.diao.linkedList;

/**
 * @program: DataStructure
 * @description: 结点
 * @author: Mr.diao
 * @create: 2019-06-18 10:23
 **/
public class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName) {
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
