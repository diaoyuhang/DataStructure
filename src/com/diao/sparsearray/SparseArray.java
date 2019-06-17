package com.diao.sparsearray;

import java.io.*;

/**
 * @program: DataStructure
 * @description: 稀疏数组
 * @author: Mr.diao
 * @create: 2019-06-17 09:55
 **/
public class SparseArray {
    public static void main(String[] args) throws IOException {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        stringBuffer.append(2);
        stringBuffer.append(3);
        stringBuffer.append(4);

        System.out.println(stringBuffer.toString().split(""));

        //原始数组
        int[][] originalArr = new int[11][11];
        originalArr[1][2] = 1;
        originalArr[2][3] = 2;
        originalArr[3][4] = 2;

        for (int[] row : originalArr) {

            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        //遍历二维数组，得到非0的个数
        for (int i = 0; i < originalArr.length; i++) {
            for (int data : originalArr[i]) {
                if (data != 0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        //遍历二维数组，将非0值存放到sparseArray数组中
        for (int i = 0; i < originalArr.length; i++) {
            for (int j = 0; j < originalArr[i].length; j++) {
                if (originalArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originalArr[i][j];
                }
            }
            continue;
        }

        //将稀疏数组保存到本地
        File file = new File("e://sparsearray.data");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            for (int[] arr : sparseArray) {
                writer.write(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("输出稀疏数组~~");
        for (int[] arr : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", arr[0], arr[1], arr[2]);
        }

        //从文件中读取恢复二维数组
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        String[] splits = line.split("\t");


        //将稀疏数组转换为二维数组
        int[][] originalArr2 = new int[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])];

        while ((line = bufferedReader.readLine()) != null) {
            String[] strs = line.split("\t");
            originalArr2[Integer.parseInt(strs[0])][Integer.parseInt(strs[1])] = Integer.parseInt(strs[2]);
        }
       /* for (int i = 1; i < sparseArray.length; i++) {
            originalArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }*/

        //输出恢复后的数组
        for (int[] arr : originalArr2) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
