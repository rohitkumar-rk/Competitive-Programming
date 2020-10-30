
public class StackUse{
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		StackUsingArray stack = new StackUsingArray();
		for(int i=0;i<5;i++)
			stack.push(i);

		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}

		System.out.println("Using Linked List");
		System.out.println("--------------------");
		StackUsingLL<Integer> stackLL = new StackUsingLL<Integer>();
		for(int i=1;i<=5;i++)
			stackLL.push(i);
		

		while(!stackLL.isEmpty()){
			System.out.println(stackLL.pop());
		}

	}
}