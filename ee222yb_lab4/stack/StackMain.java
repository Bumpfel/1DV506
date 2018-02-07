package ee222yb_lab4.stack;

import java.util.Iterator;

public class StackMain {

	public static void main(String[] args) {
		try {
			StackList list = new StackList();

			list.push("hej");
			list.push("på");
			list.push("dig");
			list.push("!");
			
			System.out.println("Popping top element - " + list.pop());
			System.out.println("Peeking at top element - " + list.peek());
			System.out.println("Peeking at top element - " + list.peek());

			System.out.println("Size: " + list.size());
			Iterator<Object> it = list.iterator();
			System.out.println("\nDisplaying what's left in the stack");

			while(it.hasNext()) {
				System.out.println(it.next());
			}
			System.out.println("StackList is empty: " + list.isEmpty());
		}
		catch(IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
