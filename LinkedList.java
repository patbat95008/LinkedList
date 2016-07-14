import java.util.*;

class Node{
	public Node next;
	public Node prev;
	
	private String data;
	
	public Node(){
		this.next = null;
		this.prev = null;
		
		this.data = null;
	}
	
	public Node(String data){
		this.next = this.prev = null;
		
		this.data = data;
	}
	
	public Node(Node next, Node prev, String data){
		this.next = next;
		this.prev = prev;
		
		this.data = data;
	}
	
	public String getData(){
		return data;
	}
	
	public void setData(String data){ this.data = data;}
}

class LinkedList{
	public Node head;
	public Node tail;
	
	public LinkedList(){
		head = tail = null;
	}
	
	public void insert(String data){
		if(this.head == null){
			Node in = new Node(null, null, data);
			head = tail = in;
		}else{
			Node nxt = new Node(data);
			tail.next = nxt;
			nxt.prev = tail;
			tail = nxt;
		}
	}
	
	public void delete(String deleteMe){
		Node index = this.head;
		while(index != null){
			if( deleteMe.equals( index.getData() ) ){
				if(index != head && index != tail){
					index.prev.next = index.next;
					index.next.prev = index.prev;
					break;
				}else if(index == head){
					head = head.next;
					break;
				}else if(index == tail){
					tail = tail.prev;
					break;
				}
			}
			index = index.next;
		}
		
		throw new IndexOutOfBoundsException("No " + deleteMe + " found in list\n");
	}
	
	public void printList(){
		Node index = this.head;
		while(index != null){
			System.out.println(index.getData());
			index = index.next;
		}
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		
		list.insert("LOL");
		list.insert("JEJ");
		list.insert("foo");
		
		list.printList();
		System.out.printf("\n -- \n");
		try{
			list.delete("f");
		}catch(IndexOutOfBoundsException e){
			System.out.println("404 item not found");
		}
		list.printList();
	}
}