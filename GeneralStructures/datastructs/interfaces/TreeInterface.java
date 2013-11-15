package datastructs.interfaces;

public interface TreeInterface<K> extends DataStructure<K> {
	public boolean delete(K pk);
	public boolean exists(K pk);
    public boolean insert(K pk);
    public boolean isEmpty();
    public int length();
    public boolean setEmpty();
}