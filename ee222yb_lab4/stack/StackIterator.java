package ee222yb_lab4.stack;

import java.util.Iterator;

public class StackIterator implements Iterator<Object> {

	private int nextIndex = 0;
	private Object[] array;
	private int maxIndex;
	
	public StackIterator(Object[] arr, int size) throws IndexOutOfBoundsException {
		if(size > arr.length)
			throw new IndexOutOfBoundsException("Cannot create iterator. Index out of bounds");
		array = arr;
		maxIndex = size;
	}

	public boolean hasNext() {
		return nextIndex < maxIndex;
	}

	public Object next() {
		return array[nextIndex++];
	}
		
}