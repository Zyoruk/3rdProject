package datastructs.queue;

import datastructs.doublelist.DoubleList;
import datastructs.doublelist.DoubleListNode;
import datastructs.interfaces.QueueInterface;

/**
* Class to create a Queue. It extends from DoubleList because each node
* has references to the previous and next nodes of the list.
* @author zyoruk,jeukel
*
* @param <K>
*/
public class PriorityQueue<K> extends DoubleList<K> implements QueueInterface<K> {


	/**
	 * Removes the last node.
	 */
	public int Dequeue(){
		int removed = (Integer) super.cut();
		return removed;
	}

	/**
	 * Adds to the first position
	 * @param pk
	 */

	@Override
	public void Enqueue(K pk) {
 
            super.insert(pk);
	}

	public boolean Enqueue(K pk, int priori){
		DoubleListNode<K> node = new DoubleListNode<K>(pk);
		node.setPriority(priori);
		int i;

		// Check valid position
		if(priori < 1 || priori > 500){
			return false;
		}

		// Search priority
		DoubleListNode<K> current = this.head;
		for(i = 1; current.getPriority() > current.getNext().getPriority()
				;i++) {

			if(current == this.tail){
				break;
			}
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
		return true;
	}

	/**
	 *
	 * @return Gets the element of the first node as a string.
	 */
	public String Peek(){
		return super.returnElem();
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(K pk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}


}

