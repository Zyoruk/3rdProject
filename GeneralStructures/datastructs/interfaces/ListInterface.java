package datastructs.interfaces;
/**
 * @author zyoruk
 * This is the model every List should follow.
 * @param <K> This implements Generics, which means we could build a list of 
 * any type.
 */
public interface ListInterface<K> extends DataStructure<K> {
	/**
	 * Adds at the end of the list
	 * @param pk
	 * @return true if was appended or false if it didn't
	 */
    public boolean append(K pk);
    
    /**
     * Clears the list
     * @return true or false
     */
    public boolean clear();
    
    /**
     * removes the last element of the list
     * @return the element remmoved
     */
    public K cut();
//
//	/**
//	 * calcualtes the time an operation took to execute
//	 * @return
//	 */
//    public double getExecuteTime();
    
    /**
     * Deletes the first element
     * @return true or false
     */
    public boolean delete();
    
    /**
     * deletes the element specified as a parameter
     * @param pk
     * @return true or false depending if it was able to delete
     */
    public boolean delete(K pk);
    
    /**
     * Inserts at the specified position
     * @param pos integer
     * @param pk element to insert
     * @return true or false
     */
    public boolean insert(int pos, K pk);
    
    /**
     * Insert the elementn in the first position
     * @param pk
     * @return true or false
     */
    public boolean insert(K pk);
}