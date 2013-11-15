package datastructs.interfaces;

/**
 * 
 * @author zyoruk
 * Model every stack should follow.
 * @param <K> 
 */
public interface StackInterface<K> extends DataStructure<K>{
	/**
     * Pop will delete the first element and return true or false depending if
     * it was able to delete it.
     * @return true if it was able to delete, false if not.
     */
    public boolean pop();
    
    /**
	 * Push will set the parameter as the first element of te stack.
	 * This uses a temporal stack.
	 * @param pk
	 * @return true if it pushed , false if not.
	 */
    public boolean push(K pk);
    
    /**
     * Top will take the first element of the stack and return it as a String.
     * The element won't be deleted
     * @return the element as a String
     */
    public String top();
    
//    /**
//     * Calculates the time it took to push, top or pop.
//     * It uses the System.getCurrentMillis().
//     * @return	the time it takes to do an operation.
//     */
//    public double getExecuteTime();
}
