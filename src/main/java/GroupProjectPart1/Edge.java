/*
    Khaled mohammed alasmari - 2035189
    Omar abdulbagi - 2037070
    Salman alhothly - 2044556
*/
package GroupProjectPart1;

/**
 *
 * @author khaled
 */
public class Edge implements Comparable<Edge> {

    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public int compareTo(Edge e) {
        return Double.compare(this.cost, e.cost);
    }
}
