/*

    Khaled mohammed alasmari - 2035189
    Omar abdulbagi - 2037070
    Salman alhothly - 2044556

*/
package GroupProjectPart1;

import java.util.ArrayList;

/**
 *
 * @author khaled
 */
public class PrimAlgorithm {

    public static ArrayList<Edge> findMST(Graph graph, int source, QueueType queueType) {
        if (queueType == QueueType.ARRAY) {
            return findMST(graph, source, new MinPriorityQueueUsingArray(graph.getNumberOfEdges()));

        } else {
            return findMST(graph, source, new MinPriorityQueueUsingHeap(graph.getNumberOfEdges()));
        }
    }

    private static ArrayList<Edge> findMST(Graph graph, int source, MinPriorityQueue queue) {
        boolean[] visited = new boolean[graph.getnVerts()];
        visited[source] = true;
        ArrayList<Edge> includedEdges = new ArrayList<>();
        MinPriorityQueue priorityQueue = queue;
        Vertex[] verticesList = graph.getVertexList();
        for (Edge edge : verticesList[source].neighbors) {
            priorityQueue.insert(edge);
        }
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.extractMin();
            if (visited[edge.end]) {
                continue;
            }
            visited[edge.end] = true;
            includedEdges.add(edge);
            for (Edge neighbor : verticesList[edge.end].neighbors) {
                priorityQueue.insert(neighbor);
            }
        }
        return includedEdges;
    }
}
