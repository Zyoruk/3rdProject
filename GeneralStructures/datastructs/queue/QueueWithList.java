package datastructs.queue;

import datastructs.doublelist.DoubleList;
import datastructs.interfaces.QueueInterface;

public class QueueWithList<K> extends DoubleList<K> implements QueueInterface<K> {	
	
	public int Dequeue(){
		int removed = (Integer) super.cut();
		return removed;
	}
	
	public void Enqueue(K pk){
		super.insert(pk);
	}

	public String Peek(){
		return super.returnElem();
	}

}
