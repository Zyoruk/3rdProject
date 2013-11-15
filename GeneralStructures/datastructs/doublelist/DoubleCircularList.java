package datastructs.doublelist;

import java.util.Iterator;

import datastructs.interfaces.ListInterface;

public class DoubleCircularList<K> implements ListInterface<K>, Iterable<K> {
    
    //    protected double _start;
//    protected double _end;
    protected DoubleListNode<K> head;
protected int length;
    protected DoubleListNode<K> tail;

    public DoubleCircularList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    
    @Override
    public boolean append(K pk) {
//    	_start = System.currentTimeMillis();
        DoubleListNode<K> node = new DoubleListNode<K>(pk);

        if(isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        }
        this.tail = node;
        this.length += 1;
//        _end = System.currentTimeMillis();
        return true;
    }

    @Override
    public boolean clear() {
        DoubleListNode<K> temp = null;
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
//		_start = System.currentTimeMillis();
		// TODO Auto-generated method stub
//		_end = System.currentTimeMillis();
//		System.out.println("Cut lasted:  " + getExecuteTime());
		DoubleListNode<K> p = new DoubleListNode<K>(null); 
		return p.getElem();
	}

    //Delete head
	@Override
	public boolean delete() {
//		_start = System.currentTimeMillis();
		//Set tmp list
        DoubleListNode<K> node = this.head.getNext();
        
        //Destroy
        this.head.getNext().setPrevious(null);
        this.head = null;
                
        //Set new list
        this.head = node;
//        System.out.println("Delete lasted:  " + getExecuteTime());
//        _end = System.currentTimeMillis();
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
        if(this.length == 1) {
            if(this.head.getElem().equals(pk)) {
                clear();
                this.length -= 1;
//                _end = System.currentTimeMillis();
//                System.out.println("Delete lasted:  " + getExecuteTime());
                return true;
            }
//            _end = System.currentTimeMillis();
//            System.out.println("Delete lasted:  " + getExecuteTime());
            return false;
        }
        
        DoubleListNode<K> current = this.head;
        while(current != null) {
            if(current.getElem().equals(pk)) {
                // Remove node
                if(current == this.tail){
                	this.tail = current.getPrevious();
                	current.getPrevious().setNext(current.getNext());
                	this.length -= 1;
//                	_end = System.currentTimeMillis();
//                	System.out.println("Delete lasted:  " + getExecuteTime());
                	return true;
                }
                if (current == this.head){
                	this.head = current.getNext();
                	current.getNext().setPrevious(current.getPrevious());
                	this.length -= 1;
//                	_end = System.currentTimeMillis();
//                	System.out.println("Delete lasted:  " + getExecuteTime());
                	return true;
                }
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                current.setNext(null);
                current = null;
                this.length -= 1;
//                _end = System.currentTimeMillis();
//                System.out.println("Delete lasted:  " + getExecuteTime());
                return true;
            }            
            current = current.getNext();
        }        
//        _end = System.currentTimeMillis();
//        System.out.println("Delete lasted:  " + getExecuteTime());
        return false;
    }

    public String describe() {
        StringBuilder result = new StringBuilder();

        result.append("List: ");
//        for(K k : this) {
//            result.append(String.format("%s ", k.toString()));
//        }
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
//            	System.out.println("Search lasted:  " + getExecuteTime());
                return true;
            }
        }
//        _end = System.currentTimeMillis();
//        System.out.println("Search lasted:  " + getExecuteTime());
        return false;
    }
    
    @Override
    public boolean insert(int pos, K pk) {
//    	_start = System.currentTimeMillis();
        DoubleListNode<K> node = new DoubleListNode<K>(pk);
        int i;

        // Check valid position
        if((pos < 0) || (pos > this.length)) {
//        	_end = System.currentTimeMillis();
//        	System.out.println("Insert lasted:  " + getExecuteTime());
            return false;
        }

        // Search position
        DoubleListNode<K> current = this.head;
        for(i = 0; i != pos; i++) {
            current = current.getNext();
        }
        
        // Insert node
        if(this.length == i){
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        } else {
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            if(current.getPrevious() != null) {
                current.getPrevious().setNext(node);
                current.setPrevious(node);
            }
        }

        // Check head
        if(current == this.head) {
            this.head = node;
        }
        // Check tail
        if(this.length == i){
            this.tail = tail.getNext();
        }
        this.length += 1;
//        _end = System.currentTimeMillis();
//        System.out.println("Insert lasted:  " + getExecuteTime());
        return true;
    }
    
    //Insert as head
    @Override
    public boolean insert(K pk) {
//    	_start = System.currentTimeMillis();
        DoubleListNode<K> node = new DoubleListNode<K>(pk);

        // Insert node
        node.setNext(this.head);
        node.setPrevious(this.tail);
        
        this.head = node;
        //First insert
        if(isEmpty()) {
            this.tail = node;
        }
        
        this.tail.setNext(this.head);
        this.head.getNext().setPrevious(this.tail);

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
        return new DoubleCircularListIterator<K>(this);
    }

	@Override
    public int length() {
        return this.length;
    }

//	@Override
//	public double getExecuteTime() {
//		return _end - _start;
//	}
}

class DoubleCircularListIterator<K> implements Iterator<K> {

    DoubleListNode<K> current;
    DoubleCircularList<K> list;
    
    public DoubleCircularListIterator(DoubleCircularList<K> list) {
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
