package com.diao.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: DataStructure
 * @description:
 * @author: Mr.diao
 * @create: 2019-07-03 10:18
 **/
public class Graph {
    private List<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited;//表示是否访问过

    public static void main(String[] args) {
        String vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(vertexs.length);

        for (String str : vertexs) {
            graph.insertVertex(str);
        }
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        graph.dfs();
        System.out.println("--------------------------");
        graph.bfs();

    }

    public Graph(int n) {
        //初始化邻接矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }


    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        linkedList.add(i);

        while (!linkedList.isEmpty()) {
            //取出队列的头结点的下标
            int u = linkedList.removeFirst();
            //得到第一个邻接结点的下标
            int w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    linkedList.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }

        }

    }


    //深度优先遍历的重载
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //深度优先遍历
    private void dfs(boolean[] isVisited, int i) {
        //输出访问到的结点
        System.out.print(getValueByIndex(i) + "->");
        //将这个点设置为已被访问
        isVisited[i] = true;
        //查找i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有邻接点
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);

        }


    }


    //根据上一个邻接点查找下一个临界点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //得到第一个邻接结点的下标,没有临界点就返回-1
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //返回结点个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示对应的矩阵
    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    //得到边的数目
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回两个顶点的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
}
