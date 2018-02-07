package ee222yb_lab4.stack;

import java.util.Iterator;

public class StackList implements Stack {

	private Object[] stackList;
	private int length = 10; // array start length
	private int curSize = 0; // companion
	
	public StackList() {
		stackList = new Object[length];
	}
	
	public int size() {
		return curSize;
	}
	
	public boolean isEmpty() {
		return curSize == 0;
	}
	
	public void push(Object element) {
		if(curSize == length)
			resize();
		stackList[curSize++] = element;
	}
	
	public Object pop() throws IndexOutOfBoundsException {
		if(curSize == 0)
			throw new IndexOutOfBoundsException("Method pop() failed: No element");
		Object temp = stackList[--curSize];
		stackList[curSize] = null;
		return temp;
	}
	
	public Object peek() throws IndexOutOfBoundsException {
		if(curSize == 0)
			throw new IndexOutOfBoundsException("Method peek() failed: No element");
		return stackList[curSize - 1];
	}
	
	public Iterator<Object> iterator() throws IndexOutOfBoundsException {
		return new StackIterator(stackList, curSize);
	}
	
	private void resize() {
		length *= 2;
		Object[] temp = new Object[length];
		for(int i = 0; i < stackList.length; i ++) {
			temp[i] = stackList[i];
		}
		stackList = temp;
	}
}
