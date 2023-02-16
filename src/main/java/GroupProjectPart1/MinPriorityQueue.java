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
public abstract class MinPriorityQueue {
    
    
    
    public abstract Edge getMin();
    public abstract Edge extractMin();
    public abstract void insert(Edge val);
    public abstract boolean isEmpty();

}
enum QueueType {
  ARRAY,
  HEAP,
}