package datastructs.doublelist;


import java.util.Iterator;

import datastructs.interfaces.ListInterface;

/**
 * 
 * @author Daniel
 *A class that creates a Double List this is an structure that will store data
 * @param <K>
 */
public class DoubleList<K> implements ListInterface<K>, Iterable<K> {
    
    //    protected double _start;
//    protected double _end;
    protected DoubleListNode<K> head;
    protected int length;
    protected DoubleListNode<K> tail;

    public DoubleList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    
    /**
     * A method that adds data to the DoubleList 
     */
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
//        System.out.println("Append lasted:  " + getExecuteTime());
        return true;
    }

    /**
     *A method that erase all the elements on the DoubleList
     */
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

    /**
     * Method that Erase last node of the DoubleList
     */
	
	public K cut() {
//		_start = System.currentTimeMillis();
		if (this.tail == null){
//			_end = System.currentTimeMillis();
//			System.out.println("Cut lasted:  " + getExecuteTime());
			return this.tail.getElem();
		} else if (this.tail.getPrevious() == null){
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.getPrevious();
			this.tail.setNext(null);
		}
		this.length--;
//		_end = System.currentTimeMillis();
//		System.out.println("Cut lasted:  " + getExecuteTime());
		return this.tail.getElem();
	}

    /**
     * Method that erase the first node on the DoubleList 
     */
	public boolean delete() {
//		_start = System.currentTimeMillis();
		//Set tmp list
        DoubleListNode<K> node = this.head.getNext();
        
        //Destroy
        this.head.getNext().setPrevious(null);
        this.head = null;
                
        //Set new list
        this.head = node;
//        _end = System.currentTimeMillis();
//        System.out.println("Delete lasted:  " + getExecuteTime());
        return true;
	}

    /**
     * Method that erase an specific node on the DoubleList
     */
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

    /**
     * Method that shows the information of the DoubleList 
     */
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

    /**
     * Method that shows true if an element of the list that was
     * search exists on the DoubleList  
     */
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
    
    /**
     * Method that insert a node on a specific position on the 
     * DoubleList 
     */
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
    
    /**
     * Method that insert on the first place of the DoubleList 
     */
    public boolean insert(K pk) {
//    	_start = System.currentTimeMillis();
        DoubleListNode<K> node = new DoubleListNode<K>(pk);

        // Insert node
        if (this.head == null){
        	this.tail = node;
        }else{
        	node.setNext(this.head);
        	this.head.setPrevious(node);
        }
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
        return new DoubleListIterator<K>(this);
    }

	@Override
    public int length() {
        return this.length;
    }

	public String returnElem(){
    	return (String) this.head.getElem();
    }

//	@Override
//	public double getExecuteTime() {
//		double executeTime = _end - _start;
//		return executeTime;
//	}
}

class DoubleListIterator<K> implements Iterator<K> {

    DoubleListNode<K> current;
    DoubleList<K> list;
    
    public DoubleListIterator(DoubleList<K> list) {
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
