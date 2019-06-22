package com.diao.recursion;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-22 10:50
 **/
public class Maze {

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2]=1;
//        map[2][2]=1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("======================");
        setway(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * @param map: 地图
     * @param i:   从什么位置开始
     * @param j:
     * @Author: dyh
     * @Description: 使用递归回溯来找路线；1代表墙，2代表走过的点，3代表不可行点
     * @Date: 2019/6/22
     * @Return:
     */
    public static boolean setway(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//表示该点没走过

                //行走策略下左上右
                map[i][j] = 2;//表示该点已经走过
                if (setway(map, i + 1, j)) {
                    return true;
                } else if (setway(map, i, j + 1)) {
                    return true;
                } else if (setway(map, i - 1, j)) {
                    return true;
                } else if (setway(map, i, j - 1)) {
                    return true;
                } else {
                    //表示该点行不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
