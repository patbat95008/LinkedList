
public class List extends Node {
	private Node head;
	private Node tail;
	
	public List(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void clear(){
		head = null;
		tail = null;
	}
	
	public void printList(){
		Node tmp = head;
		while (tmp != tail){
			System.out.println(tmp.word);
			tmp = tmp.next;
		}
		System.out.println(tmp.word);
	}
	
	public void add(Object item){
		if(this.isEmpty())
			tail = head = new Node(item);
		else if(tail == head){
			head.next = new Node(item);
			tail = head.next;
		}else{
			tail.next = new Node(item);
			tail = tail.next;
		}
	}
	
	public Object getHead(){
		if(!this.isEmpty())
			return head.word;
		else return null;
	}
	
	public Object getTail(){
		if(!this.isEmpty())
			return tail.word;
		else return null;
	}
	
	public Object pop(){
		if(this.isEmpty()) return null;
		
		Object tmp = this.getHead();
		head = head.next;
		return tmp;
	}
	
	public void push(Object item){
		Node tmp = new Node(item);
		tmp.next = head;
		head = tmp;
	}
	
}
