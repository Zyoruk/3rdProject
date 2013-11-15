package datastructs.simplelist;
import java.util.Iterator;

import datastructs.interfaces.ListInterface;


public class SimpleList<K> implements ListInterface<K>, Iterable<K> {
    
    //    protected double _start;
//    protected double _end;
    protected SimpleListNode<K> head;
    protected int length;
    protected SimpleListNode<K> tail;

    public SimpleList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    
    @Override
    public boolean append(K pk) {
        SimpleListNode<K> node = new SimpleListNode<K>(pk);
//        _start = System.currentTimeMillis();

        if(isEmpty()) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
        this.length += 1;
//        _end = System.currentTimeMillis();
//        System.out.println("Append lasted:  " + getExecuteTime());
        return true;
    }

    @Override
    public boolean clear() {
        SimpleListNode<K> temp = null;
        while(this.head != null) {
            temp = this.head.getNext(); 
            this.head.setNext(null);
            this.head = temp;
        }
        this.tail = null;
        this.length = 0;
        return true;
    }

    @Override
	public K cut() {
		// TODO Auto-generated method stub
		SimpleListNode<K> current = this.head;
		while(current.getNext() != this.tail){
			current = current.getNext();
		}
		this.tail = current;
		current.setNext(null);
		return current.getElem();
	}

    @Override
    public boolean delete(){
//    	_start = System.currentTimeMillis();
        //Set tmp list
        SimpleListNode<K> node = this.head.getNext();
        
        //Destroy
        this.head = null;
        
        //Set new list
        this.head = node;
//        _end = System.currentTimeMillis();
//        System.out.println("Delete lasted:  " + getExecuteTime());
        return true;


    }

    @Override
    public boolean delete(K pk) {
//    	_start = System.currentTimeMillis();
        if(isEmpty()) {
//        	_end = System.currentTimeMillis();
//        	System.out.println("Delete lasted:  " + getExecuteTime());
            return false;
        }
        
        // Search node
        SimpleListNode<K> previous = null;
        SimpleListNode<K> current = this.head;
        while(current != null) {
            if(current.getElem().equals(pk)) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        // If not found
        if(current == null) {
//        	_end = System.currentTimeMillis();
//        	System.out.println("Delete lasted:  " + getExecuteTime());
            return false;
        }

        // Found, check head
        if(current == this.head) {
            this.head = current.getNext();
        }
        // Found, check tail
        if(current == this.tail) {
            this.tail = previous;
        }

        // Remove node
        if(previous != null) {
            previous.setNext(current.getNext());
        }
        current.setNext(null);
        current = null;
        this.length -= 1;
//        _end = System.currentTimeMillis();
//        System.out.println("Delete lasted:  " + getExecuteTime());
        return true;
    }

    public K deleteHead() {
//    	_start = System.currentTimeMillis();
    	SimpleListNode<K> node = this.head;
    	this.head = this.head.getNext();
//    	_end = System.currentTimeMillis();
//    	System.out.println("DeleteHead lasted:  " + getExecuteTime());
        return node.getElem();
    }
    
    public String describe() {
        StringBuilder result = new StringBuilder();

        result.append("List: ");
        for(K k : this) {
            result.append(String.format("%s ", k.toString()));
        }
        result.append("\n");

        result.append(String.format("Length: %d\n", this.length));
        result.append(
                String.format("Head: %s\n", this.head.getElem().toString())
            );
        result.append(
                String.format("Tail: %s\n", this.tail.getElem().toString())
            );

        return result.toString();
    }

    @Override
    public boolean exists(K pk) {
//    	_start = System.currentTimeMillis();
        for(K ck : this) {
            if(ck.equals(pk)) {
//            	_end = System.currentTimeMillis();
//            	System.out.println("Delete lasted:  " + getExecuteTime());
                return true;
            }
        }
//        _end = System.currentTimeMillis();
//        System.out.println("Delete lasted:  " + getExecuteTime());
        return false;
    }

    @Override
    public boolean insert(int pos, K pk) {
//    	_start = System.currentTimeMillis();

        SimpleListNode<K> node = new SimpleListNode<K>(pk);

        // Check valid position
        if((pos < 0) || (pos > this.length)) {
//        	_end = System.currentTimeMillis();
//        	System.out.println("Insert lasted:  " + getExecuteTime());
            return false;
        }

        // Search position
        SimpleListNode<K> previous = null;
        SimpleListNode<K> current = this.head;
        for(int i = 0; i != pos; i++) {
            previous = current;
            current = current.getNext();
        }

        // Insert node
        node.setNext(current);
        if(previous != null) {
            previous.setNext(node);
        }

        // Check head
        if(current == this.head) {
            this.head = node;
        }
        // Check tail
        if(previous == this.tail) {
            this.tail = node;
        }

        this.length += 1;
//        _end = System.currentTimeMillis();
//        System.out.println("Insert lasted:  " + getExecuteTime());
        return true;
    }

    @Override
    public boolean insert(K pk) {
//    	_start = System.currentTimeMillis();
        SimpleListNode<K> node = new SimpleListNode<K>(pk);

        // Insert node
        node.setNext(this.head);

        // Check head
        this.head = node;

        this.length += 1;
//        _end = System.currentTimeMillis();
//        System.out.println("Insert lasted:  " + getExecuteTime());
        return true;
    }
    

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<K> iterator() {
        return new SimpleListIterator<K>(this);
    }
	@Override
    public int length() {
        return this.length;
    }

//	@Override
//	public double getExecuteTime() {
//		double executeTime = this._end - this._start;
//		return executeTime;
//	}
}

class SimpleListIterator<K> implements Iterator<K> {

    SimpleListNode<K> current;
    SimpleList<K> list;
    
    public SimpleListIterator(SimpleList<K> list) {
        this.list = list;
        this.current = null;
    }
    
    @Override
    public boolean hasNext() {
        
        if(this.current == null) {
            if(this.list.isEmpty()) {
                return false;
            }
            this.current = this.list.head;
            return true;
        }
        
        this.current = this.current.getNext();
        return this.current != null;
    }

    @Override
    public K next() {
        if(this.current == null) {
            return null;
        }
        return this.current.getElem();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

