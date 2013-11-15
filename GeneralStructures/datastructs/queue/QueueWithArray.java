package datastructs.queue;

import datastructs.interfaces.QueueInterface;

/**
 * 
 * @author zyoruk
 * Implementation of queue using arrays.
 * Implements QueueInterface to attach to a model.
 * @param <K>
 */
public class QueueWithArray<K> implements QueueInterface<K> {
	private int indexI;
	private int indexJ;
//	private double _start;
//	private double _end;
	public boolean isEmpty;
	private int[] queue;
	
	public QueueWithArray(int size){
		this.isEmpty = true;
		this.queue = new int[size];
		this.indexI = 0;
//		this._end = 0;
//		this._start = 0;
	}
	
	/**
	 * Checks if the queue contains the element.
	 * @param pk 
	 * @return true / false
	 */
	public boolean contains (K pk){
		if(this.isEmpty){
			return false;
		}else{
			boolean contains = false;
			for (int i = 0 ; i < this.queue.length; i ++){
				if (this.queue[i] == (Integer) pk){
					contains = true;
				}
			}
			return contains;
		}
	}

	@Override
	public int Dequeue() {
//		this._start = System.currentTimeMillis();
		if (!(isEmpty)){
			indexJ ++;
		}
		if (indexI == 0 && indexJ== 0){
			isEmpty = true;
		}
		return (int)this.queue[0];
//		this._end = System.currentTimeMillis();
//		System.out.println("Dequeue lasted:  " + getExecuteTime());
	}

	@Override
	public String describe() {
        StringBuilder result = new StringBuilder();

        result.append("List: ");
        for(int i = 0; i < this.queue.length; i++) {
            result.append(String.format("%s ", Integer.toString(queue[i])));
        }
        result.append("\n");

        result.append(String.format("Length: %d\n", this.queue.length));
        return result.toString();
	}
	
	@Override
	public void Enqueue(K pk) {
//		_start = System.currentTimeMillis();
		if (isEmpty){
			this.queue[0] = (Integer) pk;
			isEmpty = false;
		}else if (!(contains(pk))){
			if ((indexI == this.queue.length -1 && indexJ == 0) | 
			   (indexI == indexJ) ){
				resize();
			}else if (indexJ > 0 ){
				indexI = 0;
			}
			queue[indexI] = (Integer) pk;
			indexI ++;
			isEmpty = false;
		}
//		_end = System.currentTimeMillis();
//		System.out.println("Enqueue lasted:  " + getExecuteTime());		
	}
	
//	/**
//	 * Calculates the execution time.
//	 * @return
//	 */
//	public double getExecuteTime(){
//		return this._end - this._start;
//	}

	@Override
	public boolean exists(K pk) {
		boolean exists= false;
		for (int i = 0 ; i < this.queue.length; i ++){
			if ( queue[i] == (Integer) pk){
				exists = true;
			}
		}
		return exists;
	}

	@Override
	public boolean isEmpty() {
		return this.queue[0] == 0;
	}

	public int length(){
		return this.queue.length;
	}

	@Override
	public String Peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void resize(){
		indexI = this.queue.length;
		indexJ = 0;
		int [] temp = new int [ (int)(this.queue.length + 
								(this.queue.length *40)/100) ];
		for (int i = 0 ; i < this.queue.length; i ++){
			temp[i] = this.queue[i];
		}
		this.queue = temp;
	}
}
