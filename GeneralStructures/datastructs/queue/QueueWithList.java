package datastructs.queue;

import datastructs.doublelist.DoubleList;
import datastructs.interfaces.QueueInterface;
/**
 * Class that Joins the Data Structures  Queue and List
 * @author Daniel 
 *
 * @param <K>
 */
public class QueueWithList<K> extends DoubleList<K> implements QueueInterface<K> {	
	
	/**
	 * Method that dequeue an element
	 * using cut
	 * @return k
	 */
	public K Dequeue(){
		K removed = super.cut();
		return removed;
	}
	
	/**
	 * Method that Enqueue using
	 * insert
	 */
	public void Enqueue(K pk){
		super.insert(pk);
	}

	/**
	 * Method that peek a element from the list 
	 * @return String
	 */
	public String Peek(){
		return super.returnElem();
	}

}
