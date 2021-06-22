import java.util.*;

// @author: Sarah Sweeney

public class MyArrayList<T> implements ListInterface<T>{
	protected T[] elements;
	protected int topIndex = -1;
	
	public MyArrayList() {
		elements = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int maxSize) {
		elements = (T[]) new Object[maxSize];
	}
	
	public void add(T t) {
		T[] tempArray = (T[]) new Object[elements.length + 1];
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == null) {
				elements[i] = t;
				break;
			}
		}
		if (size() == elements.length) {
			for (int i = 0; i < elements.length; i++) {
				tempArray[i] = elements[i];
			}
		tempArray[elements.length] = t;
		elements = tempArray;
		}
		topIndex++;
	}
	
	public T get(int pos) throws MyIndexOutOfBoundsException {
			if (pos < 0 || pos > size()) {
				throw new MyIndexOutOfBoundsException("My Index Out of Bounds Exception");
			}
			else {
				return elements[pos];
			}
	}
	
	public boolean remove(T t) {
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(t)) {
				for (int k = i; k < elements.length - 1; k++) {
					elements[k] = elements[k+1];
				}
				elements[elements.length - 1] = null;
				topIndex--;
				return true;
			}
		}
		return false;
	}
	
	public void remove(int pos) throws MyIndexOutOfBoundsException {
		T[] tempArray = (T[]) new Object[elements.length - 1];
		
		if (pos >= elements.length || elements[pos] == null) {
			throw new MyIndexOutOfBoundsException("My Index Out of Bounds Exception");
		}
		//else if (pos >= elements.length) {
		//	throw new ArrayIndexOutOfBoundsException ("Array Index Out of Bounds Exception");
		//}
		else {
			for (int i = 0, j = 0; i < elements.length; i++) {
				if (i != pos) {
					tempArray[j++] = elements[i];
				}
			}
			elements = tempArray;
			topIndex--;
		}
	}
	
	public void add(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		if (topIndex < 0 || topIndex > elements.length) {
			throw new MyIndexOutOfBoundsException("Index Out of Bounds Exception");
		} else if (pos > elements.length) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds Exception");
		} else {
			T[] tempArray = (T[]) new Object [elements.length+1];
			for (int i = 0; i < pos; i++) {
				tempArray[i] = elements[i];
			}
			tempArray[pos] = t;
			
			for (int i = pos; i < elements.length; i++) {
				tempArray[i+1] = elements[i];
			}
			elements = tempArray;
			topIndex++;
		}
	}
		
			
	public void set(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		if (topIndex < 0 || topIndex > elements.length ) {
			throw new MyIndexOutOfBoundsException("My Index Out of Bounds Exception");
		}
		else if (pos > elements.length) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds Exception");
		}
		else {
			elements[pos] = t;
			}
	}
	
	public boolean contains(T t) {
		for (T element : elements) {
			if (element == t) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
	}
	
	public boolean isEmpty() {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				return false;
			}
		}
		return true;
	}
}
