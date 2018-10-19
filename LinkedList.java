package lab1.linkedList;

public class LinkedList {
 
	private int counter;
	private Node head;
 
	public LinkedList() {
		counter = 0;
		head = new Node(0);
	}
 

	// appends the specified element to the end of this list.
	public void add(Object data) {
 		
 		Node it = head;
 		
 		while(it.getNext() != null)
 			it = it.getNext();
 			
 		it.setNext(new Node(data));

 		counter++;	
	}
  
	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {
 		
 		Node it = head;
 		int n = 0;
 		
 		while(it.getNext() != null && n != index)
 		{	
 			it.setNext(it.getNext());
 			n++;
 		}
 		
 		it.setNext(new Node(data, it.getNext()));

 		counter++;		
 		
	}
 
	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		Node it = head;
 		while(it.getNext() != null && index != 0)
 		{	
 			it = it.getNext();
 			index--;
 		}
 		
 		return it.getData();
 
	}
 
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
 		Node it = head;
 		int n = 0;
 		
 		while(it.getNext() != null && n != index)
 		{	
 			it = it.getNext();
 			n++;
 		}
 		
 		it.setNext(it.getNext().getNext());
 		counter--;	
 		return true;
	}
 
	// returns the number of elements in this list.
	public int size() {
		return counter;
	}
 
	
	public String toString() {
		Node it = head;
		String x = "[";
		while(it != null)
		{
			x = x + it.getData(); 
			if(it.getNext() != null) x += ",";
			it = it.getNext();
		}
		return x + "]";
	}
 
	private static class Node {
		// reference to the next node in the chain, or null if there isn't one.
		Node next;
 
		// data carried by this node. could be of any type you need.
		Object data;
 
		// Node constructor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
 
		// another Node constructor if we want to specify the node to point to.
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}
 
		// these methods should be self-explanatory
		public Object getData() {
			return data;
		}
 
		@SuppressWarnings("unused")
		public void setData(Object dataValue) {
			data = dataValue;
		}
 
		public Node getNext() {
			return next;
		}
 
		public void setNext(Node nextValue) {
			next = nextValue;
		}
 
	}
	
	public static void main(String[] args) {
		 
		// Default constructor - let's put "0" into head element.
		
		
		LinkedList list = new LinkedList();
 
		// add more elements to LinkedList
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
 
		/*
		 * Please note that primitive values can not be added into LinkedList directly. They must be converted to their
		 * corresponding wrapper class.
		 */
 
		System.out.println("Print: list: \t\t" + list);
		System.out.println(".size(): \t\t" + list.size());
		System.out.println(".get(3): \t\t" + list.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".remove(2): \t\t" + list.remove(2) + " (element removed)");
		System.out.println(".get(3): \t\t" + list.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".size(): \t\t" + list.size());
		System.out.println("Print again - list: \t" + list);
	}

}
