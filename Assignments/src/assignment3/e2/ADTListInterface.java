package assignment3.e2;

public interface ADTListInterface {
	public boolean isEmpty();
	public int getLength();
	public void insert(int i, Object o) throws ListException;
	public void remove(int i) throws ListException;
	public void removeAll();
	public Object get(int i) throws ListException;
}
