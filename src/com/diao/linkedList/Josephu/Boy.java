package com.diao.linkedList.Josephu;

/**
 * @program: DataStructure
 * @description: 节点
 * @author: Mr.diao
 * @create: 2019-06-19 11:02
 **/
public class Boy {

    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
