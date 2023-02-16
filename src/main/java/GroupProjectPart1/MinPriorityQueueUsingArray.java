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
public class MinPriorityQueueUsingArray extends MinPriorityQueue {

    private Edge[] array;
    private int currentElementIndex;
    private int maxSize;

    public MinPriorityQueueUsingArray(int queueSize) {
        array = new Edge[queueSize];
        maxSize = queueSize;
        currentElementIndex = 0;
    }

    @Override
    public void insert(Edge val) {
        array[currentElementIndex++] = val;
    }
    
    @Override
    public Edge extractMin() {
        int minEdgeIndex = -1;
        int minEdgeWeight = Integer.MAX_VALUE;
        for(int i = 0; i < currentElementIndex; i++){
            if(array[i].cost < minEdgeWeight){
                minEdgeWeight = array[i].cost;
                minEdgeIndex = i;
            }
        }
        swapArrayElements(array, minEdgeIndex, currentElementIndex-1);
        return array[--currentElementIndex];
    }

    public boolean isEmpty() {
        return currentElementIndex == 0;
    }
    private void swapArrayElements(Edge[] array, int index1, int index2) {
        Edge temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    @Override
    public Edge getMin() {
        return array[currentElementIndex - 1];
    }

}
