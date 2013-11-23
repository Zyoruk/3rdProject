package datastructs.simplelist;

/**
 * Class that made a simple list of nodes 
 * @author Daniel
 *
 * @param <K>
 */

public class SimpleListNode<K> {
    
    protected K elem;
    protected SimpleListNode<K> next;
    
    public SimpleListNode(K elem) {
        this.elem = elem;
        this.next = null;
    }
    public SimpleListNode(K elem, SimpleListNode<K> next) {
        this.elem = elem;
        this.next = next;
    }
    /**
     * Method that return the list element 
     * @return K
     */
    public K getElem() {
        return this.elem;
    }
    /**
     * Method that the next position of the list 
     * @return SimpleListNode<K>
     */
    public SimpleListNode<K> getNext() {
        return this.next;
    }
    /**
     * Method that set the next element 
     * @param next
     */
    public void setNext(SimpleListNode<K> next) {
        this.next = next;
    }
}
