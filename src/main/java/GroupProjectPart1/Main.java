/*

    Khaled mohammed alasmari - 2035189
    Omar abdulbagi - 2037070
    Salman alhothly - 2044556

*/
package GroupProjectPart1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author khaled
 */
public class Main {

    private static Scanner input;
    private static Graph graph;

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        input = new Scanner(inputFile);
        graph = new Graph();
        int numberOfVertices = getNumberOfVertices();
        int numberOfEdges = getNumberOfEdges();
        addVerticesToGraph(numberOfVertices);
        addEdgesToGraph(numberOfEdges);
        printPrimOutput(graph, 0, QueueType.ARRAY);
        printPrimOutput(graph, 0, QueueType.HEAP);
        printKruskalOutput(graph);
    }

    private static void printKruskalOutput(Graph graph) {
        long startTime = System.nanoTime();
        ArrayList<Edge> edges = KruskalAlgorithm.findMST(graph);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        int totalCost = getTotalCost(edges);
        printTotalCost(totalCost, "Kruskal's algorithm");
        printEdges(edges);
        printTimeTaken(timeTaken, "Kruskal’s algorithm using Union-Find approach");

    }

    private static void printPrimOutput(Graph graph, int source, QueueType queueType) {
        long startTime = System.nanoTime();
        ArrayList<Edge> edges = PrimAlgorithm.findMST(graph, source, queueType);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        int totalCost = getTotalCost(edges);
        if (queueType == QueueType.ARRAY) {
            printTotalCost(totalCost, "Prim's algorithm (Using unordered Min-Priority queue)");
        } else {
            printTotalCost(totalCost, "Prim's algorithm (Using Min-Heap)");
        }
        printEdges(edges);
        if (queueType == QueueType.ARRAY) {
            printTimeTaken(timeTaken, "Prim's algorithm (Using unordered Min-Priority queue)");
        } else {
            printTimeTaken(timeTaken, "Prim's algorithm (Using Min-Heap)");
        }
    }

    private static void printTimeTaken(long timeTaken, String algorithmName) {
        System.out.printf("\nRunning time of %s is %d Nano seconds\n\n", algorithmName, timeTaken);
    }

    private static void printEdges(ArrayList<Edge> edges) {
        System.out.println("The edges in the MST are: ");
        for (Edge edge : edges) {
            System.out.printf("Edge from %d to %d has weight %d.0\n", edge.start, edge.end, edge.cost);
        }
    }

    private static void printTotalCost(int totalCost, String algorithmName) {
        System.out.printf("Total weight of MST by %s: %d.0\n", algorithmName, totalCost);
    }

    private static int getTotalCost(ArrayList<Edge> edges) {
        int totalCost = 0;
        for (Edge edge : edges) {
            totalCost += edge.cost;
        }
        return totalCost;
    }

    public static int getNumberOfVertices() {
        return Integer.parseInt(input.nextLine());
    }

    public static int getNumberOfEdges() {
        return Integer.parseInt(input.nextLine());
    }

    public static void addEdgesToGraph(int numberOfEdges) {
        for (int i = 0; i < numberOfEdges; i++) {
            String[] edgeInfo = input.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(edgeInfo[0]), Integer.parseInt(edgeInfo[1]), Integer.parseInt(edgeInfo[2]));
        }
    }

    public static void addVerticesToGraph(int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            graph.addVertex(i);
        }
    }
}
