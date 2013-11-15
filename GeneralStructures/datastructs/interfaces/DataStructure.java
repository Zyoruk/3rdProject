/**
 * 
 */
package datastructs.interfaces;

/**
 * @author zyoruk
 *
 */
public interface DataStructure <K> {
	/**
     * Describes the list. Length, head , list, tail.
     * @return a description of the list.
     */
    public String describe();
	
	/**
     * Checks if the element is already in the list
     * @param pk
     * @return return true or false depending if the element exists or not.
     */
    public boolean exists(K pk);
	
    /**
	 * checks if the list is empty
	 * @return true or false
	 */
	public boolean isEmpty();
	
    /**
	 * Return the size of the list
	 * @return an integer
	 */
	public int length();
}
