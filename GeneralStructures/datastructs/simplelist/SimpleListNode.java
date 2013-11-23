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
    
    public K getElem() {
        return this.elem;
    }

    public SimpleListNode<K> getNext() {
        return this.next;
    }
    
    public void setNext(SimpleListNode<K> next) {
        this.next = next;
    }
}
