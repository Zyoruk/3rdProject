package datastructs.doublelist;



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
    
    public K getElem() {
        return this.elem;
    }
    
    public DoubleListNode<K> getNext() {
        return this.next;
    }

    public DoubleListNode<K> getPrevious() {
        return this.previous;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public void setNext(DoubleListNode<K> next) {
        this.next = next;
    }
    public void setPrevious(DoubleListNode<K> previous) {
        this.previous = previous;
    }

    public void setPriority(int priori) {
        this.priority = priori;
    }
}