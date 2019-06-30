package com.diao.huffmanCode;

import java.util.*;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-06-30 14:09
 **/
public class HuffmanCode {
    static Map<Byte, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String contents = "i like like like java do you like a java";
        byte[] bytes = contents.getBytes();

//        List<Node> nodes = getNodes(bytes);
//        Node node = huffmanTree(nodes);
//
//        getCodes(node);
//
//        byte[] zip = zip(bytes);
//        System.out.println(Arrays.toString(zip));
        byte[] zip = huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));

        byte[] decode = decode(zip);
        System.out.println(new String(decode));
    }

    //解码
    public static byte[] decode(byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);

            stringBuilder.append(byteToBitString(b, !flag));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map2 = new HashMap<>();
        for (Map.Entry<Byte, String> m : map.entrySet()) {
            map2.put(m.getValue(), m.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String substring = stringBuilder.substring(i, i + count);
                if (map2.containsKey(substring)) {
                    b = map2.get(substring);
                    flag = false;
                } else {
                    count++;
                }
            }
            i += count;
            list.add(b);
        }

        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * @param b:
     * @param flag:
     * @Author: dyh
     * @Description: 将一个byte 转成一个二进制的字符串
     * @Date: 2019/6/30
     * @Return:
     */
    public static String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;//进行与操作
        }
        String str = Integer.toBinaryString(temp);

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }


    public static byte[] huffmanZip(byte[] bytes) {

        List<Node> nodes = getNodes(bytes);
        Node node = huffmanTree(nodes);

        getCodes(node);
        return zip(bytes);
    }


    /**
     * @param bytes: 这时原始的字符串对应的 byte[]
     * @Author: dyh
     * @Description: 将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @Date: 2019/6/30
     * @Return:
     */
    public static byte[] zip(byte[] bytes) {
        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(map.get(b));
        }

        int len = (builder.length() + 7) / 8;
        //创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;

        for (int i = 0; i < builder.length(); i += 8) {
            String str;
            if ((i + 8) >= builder.length()) {//不够8位
                str = builder.substring(i);
            } else {
                str = builder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(str, 2);
            index++;
        }

        return huffmanCodeBytes;
    }

    //重载getCodes
    public static void getCodes(Node node) {
        getCodes(node.left, "0", sb);
        getCodes(node.right, "1", sb);
    }

    /**
     * @param node:
     * @param code:                路径 左子结点是 0, 右子结点 1
     * @param stringBuilder:用于拼接路径
     * @Author: dyh
     * @Description: 将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @Date: 2019/6/30
     * @Return:
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);

        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            } else {
                map.put(node.data, stringBuilder1.toString());
            }
        }
    }

    //先序遍历
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        node.preOrder();
    }

    /**
     * @param nodes:
     * @Author: dyh
     * @Description: 可以通过List 创建对应的赫夫曼树
     * @Date: 2019/6/30
     * @Return:
     */
    public static Node huffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            Node newNode = new Node(null, node1.weight + node2.weight);

            newNode.left = node1;
            newNode.right = node2;

            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    /**
     * @param bytes:
     * @Author: dyh
     * @Description: 将字节数组转化成[Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......]这种形式
     * @Date: 2019/6/30
     * @Return:
     */
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();

        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }

        for (Map.Entry<Byte, Integer> m : map.entrySet()) {
            nodes.add(new Node(m.getKey(), m.getValue()));
        }
        return nodes;
    }

}
