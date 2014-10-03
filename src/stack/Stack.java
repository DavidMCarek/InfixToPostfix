package stack;

public class Stack<T>
{
	Node<T> startOfList = new Node<T>();
	
	public Stack()
	{
		startOfList.setLink(null);
	}
	
	public boolean listIsEmpty()
	{
		if (startOfList.getLink() == null)
			return true;
					
		return false;
	}
	
	public void push(T information)
	{
		Node<T> newNode = new Node<T>();
		newNode.setInfo(information);

		newNode.setLink(startOfList);
		startOfList = newNode;
	}
	
	public void pop() throws StackUnderflowException
	{
		
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to remove");
		else
			startOfList = startOfList.getLink();
	}
	
	public T top() throws StackUnderflowException
	{
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to check");
		else
			return startOfList.getValue();
	}
}
