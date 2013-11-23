package datastructs.simplelist;
import java.util.Iterator;

import datastructs.interfaces.ListInterface;
/**
 * Class than creates a simple list 
 * @author Daniel
 *
 * @param <K>
 */

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
    
    /**
     * Method that insert a node on the list 
     */
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
    
    

    /**
     * Method that erase all on the simple list 
     */
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

    /**
     * Method that erase the last node on the list 
     */
	public K cut() {
		SimpleListNode<K> current = this.head;
		while(current.getNext() != this.tail){
			current = current.getNext();
		}
		this.tail = current;
		current.setNext(null);
		return current.getElem();
	}

    /**
     *Method that is for erase the first node on the list 
     */
    public boolean delete(){
        //Set tmp list
        SimpleListNode<K> node = this.head.getNext();
        
        //Destroy
        this.head = null;
        
        //Set new list
        this.head = node;
        return true;


    }

    /**
     * Method that erase a specific node on the list 
     */
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
    /**
     * Method that erase the head of the list 
     * @return
     */
    public K deleteHead() {
    	if (this.isEmpty()){
    		return null;
    	}
    	if(this.head.getNext() != null){
	        SimpleListNode<K> node = this.head.getNext();
	        SimpleListNode<K> toreturn = this.head;
	        
	        //Destroy
	        this.head = null;
	        
	        //Set new list
	        this.head = node;
	        return toreturn.getElem();
    	}else{
    		SimpleListNode<K> toreturn = this.head;
    		this.head = null;
    		return toreturn.getElem();
    	}
    }
    /**
     * Method that describe the simple list 
     */
	public String describe() {
        StringBuilder result = new StringBuilder();
        try{
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
        }catch (NullPointerException e){
        	result = new StringBuilder();
        	result.append("nothing to describe");
        	return result.toString();
        }

        return result.toString();
    }

    /**
     * Method that shows if a node exist on the list 
     */
    public boolean exists(K pk) {
        for(K ck : this) {
            if(ck.equals(pk)) {
            	
                return true;
            }
        }
        return false;
    }

    /**
     * Method that insert a node on a specific position 
     */
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
    
    /**
     * Method that insert a node on a specific position 
     */
    public boolean replace(int pos, K pk) {
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
            try{
            	current = current.getNext();
            }catch(NullPointerException e){
            	current = null;
            }
        }

        // Insert node        
        try{
        	node.setNext(current.getNext());
        }catch(NullPointerException e){
        	node.setNext(null);
        }
        if(previous != null) {
        	previous.setNext(null);
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
//        _end = System.currentTimeMillis();
//        System.out.println("Insert lasted:  " + getExecuteTime());
        return true;
    }

    /**
     * Method that insert a node on the list 
     */
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
    

    /**
     * Method that shows if the list are empty 
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Method that made iterable the simple list 
     */
    public Iterator<K> iterator() {
        return new SimpleListIterator<K>(this);
    }
	/**
	 * 
	 *Method that return the simple list length 
	 *@return
	 */
    public int length() {
        return this.length;
    }
	/**
	 * Method that return the simple list head 
	 * @return
	 */
	public SimpleListNode<K> getHead(){
		return this.head;
	}
}
/**
 * Class implements the iterator 
 * @author Daniel
 *
 * @param <K>
 */
class SimpleListIterator<K> implements Iterator<K> {

    SimpleListNode<K> current;
    SimpleList<K> list;
    
    public SimpleListIterator(SimpleList<K> list) {
        this.list = list;
        this.current = null;
    }
    
    /**
     * Method that return if the SimpleListIterator
     * has a next element
     * @return boolean
     */
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

    /**
     * method that return the next element 
     * of the SimpleListIterator
     * @return K
     */
    public K next() {
        if(this.current == null) {
            return null;
        }
        return this.current.getElem();
    }

    /**
     * Method that remove a element of this SimpleListIterator
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

