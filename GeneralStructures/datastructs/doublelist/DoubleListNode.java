package datastructs.doublelist;

/**
 * 
 * @author Daniel
 *Class that creates a DoubleList of Nodes 
 * @param <K>
 */

public class DoubleListNode<K> {
    
    private K elem;
    private DoubleListNode<K> next;
    private DoubleListNode<K> previous;
    private int priority;
    
    public DoubleListNode(K elem) {
        this.elem = elem;
        this.next = null;
        this.previous = null;
        this.priority = 0;
    }
    public DoubleListNode(K elem, DoubleListNode<K> next) {
        this.elem = elem;
        this.next = next;
        this.previous = null;
    }
    /**
     * Method that returns the element of
     * the doublelistnode
     * @return K
     */
    public K getElem() {
        return this.elem;
    }
    /**
     * Method that return the DoubleListNode next 
     * position 
     * @return DoubleListNode<K>
     */
    public DoubleListNode<K> getNext() {
        return this.next;
    }
    /**
      * Method that return the DoubleListNode previous 
     * position 
     * @return DoubleListNode<K>
     */
    public DoubleListNode<K> getPrevious() {
        return this.previous;
    }
    /**
     * Method that return the doublelistnode priority
     * @return int
     */
    public int getPriority() {
        return this.priority;
    }
    /**
     * Method that set the doublelistnode next position
     * @param next
     */
    public void setNext(DoubleListNode<K> next) {
        this.next = next;
    }
    /**
     * Method that set the doublelistnode previous position
     * @param previous
     */
    public void setPrevious(DoubleListNode<K> previous) {
        this.previous = previous;
    }
    /**
     * Method that set the doublelistnode priority 
     * @param priori
     */
    public void setPriority(int priori) {
        this.priority = priori;
    }
}