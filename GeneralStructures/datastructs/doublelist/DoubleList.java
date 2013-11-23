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
     * @return boolean
     */
    public boolean append(K pk) {

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

        return true;
    }

    /**
     *A method that erase all the elements on the DoubleList
     *@return boolean
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
     * @return K
     */
	
	public K cut() {

		if (this.tail == null){

			return this.tail.getElem();
		} else if (this.tail.getPrevious() == null){
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.getPrevious();
			this.tail.setNext(null);
		}
		this.length--;

		return this.tail.getElem();
	}

    /**
     * Method that erase the first node on the DoubleList 
     * @return boolean
     */
	public boolean delete() {

        DoubleListNode<K> node = this.head.getNext();
        
        
        this.head.getNext().setPrevious(null);
        this.head = null;
                
        
        this.head = node;

        return true;
	}

    /**
     * Method that erase an specific node on the DoubleList
     * @return boolean
     */
    public boolean delete(K pk) {

        if(isEmpty()) {

            return false;
        }
        if(this.length == 1) {
            if(this.head.getElem().equals(pk)) {
                clear();
                this.length -= 1;

                return true;
            }

            return false;
        }
        
        DoubleListNode<K> current = this.head;
        while(current != null) {
            if(current.getElem().equals(pk)) {
               
                if(current == this.tail){
                	this.tail = current.getPrevious();
                	current.getPrevious().setNext(current.getNext());
                	this.length -= 1;


                	return true;
                }
                if (current == this.head){
                	this.head = current.getNext();
                	current.getNext().setPrevious(current.getPrevious());
                	this.length -= 1;

                	return true;
                }
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                current.setNext(null);
                current = null;
                this.length -= 1;

                return true;
            }            
            current = current.getNext();
        }        

        return false;
    }

    /**
     * Method that shows the information of the DoubleList 
     * @return String
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
     * @return boolean
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
     * Method that insert a node on a specific position on the 
     * DoubleList 
     * @return boolean
     */
    public boolean insert(int pos, K pk) {

        DoubleListNode<K> node = new DoubleListNode<K>(pk);
        int i;

        if((pos < 0) || (pos > this.length)) {

            return false;
        }

  
        DoubleListNode<K> current = this.head;
        for(i = 0; i != pos; i++) {
            current = current.getNext();
        }
        
  
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

  
        if(current == this.head) {
            this.head = node;
        }
     
        if(this.length == i){
            this.tail = tail.getNext();
        }
        this.length += 1;

        return true;
    }
    
    /**
     * Method that insert on the first place of the DoubleList 
     * @return boolean
     */
    public boolean insert(K pk) {

        DoubleListNode<K> node = new DoubleListNode<K>(pk);

        if (this.head == null){
        	this.tail = node;
        }else{
        	node.setNext(this.head);
        	this.head.setPrevious(node);
        }

        this.head = node;

        this.length += 1;

        return true;
	}
    
    /**
     * Method that shows if the double list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return this.head == null;
    }
    /**
     * Method that makes iterable the double list
     * @return Iterator<K>
     */
    public Iterator<K> iterator() {
        return new DoubleListIterator<K>(this);
    }

	/**
	 * Method that return the length of the 
	 * Double list 
	 * @return int
	 */
    public int length() {
        return this.length;
    }
    /**
     * Method that return the element of the
     * head 
     * @return String
     */
	public String returnElem(){
    	return (String) this.head.getElem();
    }


}
/**
 * Class that implements a iterable double list 
 * @author Daniel
 *
 * @param <K>
 */
class DoubleListIterator<K> implements Iterator<K> {

    DoubleListNode<K> current;
    DoubleList<K> list;
    
    public DoubleListIterator(DoubleList<K> list) {
        this.list = list;
        this.current = null;
    }
    
    /**
     * Method that shows if a node 
     * next position is a node
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
     * Method that return next node
     * @ K
     */
    public K next() {
        if(this.current == null) {
            return null;
        }
        return this.current.getElem();
    }

    /**
     * Method that removes a node 
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
