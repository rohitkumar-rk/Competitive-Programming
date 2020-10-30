
public class StackUsingLL<T>{

	Node<T> head;
	int size;

	public StackUsingLL(){
		head = null;
		size = 0;
	}

	public int size(){
		return size;
	}

	public T top() throws StackEmptyException{
		if(size() == 0)
			throw new StackEmptyException();
		return head.data;
	}

	public boolean isEmpty(){
		return (head == null);
	}

	public void push(T element){
		Node<T> newNode = new Node<T>(element);
		newNode.next = head;
		head = newNode;
		size++;
	}

	T pop() throws StackEmptyException{
		if(size() == 0)
			throw new StackEmptyException();
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}