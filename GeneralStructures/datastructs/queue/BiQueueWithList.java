package datastructs.queue;

import datastructs.interfaces.QueueInterface;
import datastructs.simplelist.SimpleList;

public class BiQueueWithList<K> extends SimpleList<K> implements QueueInterface<K> {

	private boolean isEmpty;
	private int length;
	
	public BiQueueWithList (){
		
	}
	public K DeleteFirst(){
		return super.deleteHead();
	}

	@Override
	public int Dequeue() {
		return (Integer) super.cut();
	}

	@Override
	public String describe() {
		return super.describe();
	}

	@Override
	public void Enqueue(K pk) {
		super.insert(pk);		
	}

	@Override
	public boolean exists(K pk) {
		return  super.exists(pk);
	}

	public void InsertAtEnd(K pk){
		super.append(pk);
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}
	
	@Override
	public int length() {
		return super.length();
	}
	@Override
	public String Peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
