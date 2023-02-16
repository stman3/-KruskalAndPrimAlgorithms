/*

    Khaled mohammed alasmari - 2035189
    Omar abdulbagi - 2037070
    Salman alhothly - 2044556

*/
package GroupProjectPart1;

import java.util.ArrayList;
import java.util.Stack;


public class KruskalAlgorithm {

    static void sortStack(Stack<Edge> stack) {
        Stack<Edge> buffer = new Stack<>();
        while (!stack.isEmpty()) {
            Edge temp = stack.pop();
            boolean comp = true;
            if (!buffer.empty()) {
                switch (buffer.peek().compareTo(temp)) {
                    case -1:
                        comp = false;
                        break;
                    case 1:
                        comp = true;
                        break;
                    case 0:
                        comp = false;
                        break;
                }
            }
            while (!buffer.isEmpty() && comp) {
                stack.push(buffer.pop());
            }
            buffer.push(temp);
        }
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }

    private static int[] makeSet(int size) {
        int[] id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
        return id;
    }

    static boolean findSet(int[] id, int p, int q) {
        return id[p] == id[q];
    }

    static void union(int[] id, int p, int q) {
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = id[q];
            }
        }
    }

    public static ArrayList<Edge> findMST(Graph graph) {
        Stack<Edge> stack = new Stack<>();
        ArrayList<Edge> list = new ArrayList<>();
        Vertex[] verticesList = graph.getVertexList();
        for (int i = 0; i < graph.getnVerts(); i++) {
            stack.addAll(verticesList[i].neighbors);
        }
        int[] id = makeSet(graph.getnVerts());
        sortStack(stack);
        while (!stack.isEmpty()) {
            Edge edge = stack.pop();
            int p = (edge.start);
            int q = (edge.end);
            if (!findSet(id, p, q)) {
                list.add(edge);
                union(id, p, q);
            }
        }
        return list;
    }
     
}
