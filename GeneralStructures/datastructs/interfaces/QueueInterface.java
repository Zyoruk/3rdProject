/**
 * 
 */
package datastructs.interfaces;

/**
 * @author zyoruk
 * this interface is to specify the methods every queue should implement.
 */
public interface QueueInterface<K> extends DataStructure<K> {
	/**
	 * Removes the last element
	 */
	public int Dequeue();
	/**
	 * Adds the element in the first position
	 * @param pk
	 */
	public void Enqueue(K pk);
	/**
	 * Return the last element
	 * @return returns the element as a String.
	 */
	public String Peek();
//	/**
//	 * Calculates the time an operation took to execute
//	 * @return a double .
//	 */
//	public double getExecuteTime();
}
