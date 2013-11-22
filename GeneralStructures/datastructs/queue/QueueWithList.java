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
	
	@Override
	public K Dequeue(){
		K removed = super.cut();
		return removed;
	}
	
	@Override
	public void Enqueue(K pk){
		super.insert(pk);
	}

	@Override
	public String Peek(){
		return super.returnElem();
	}

}
