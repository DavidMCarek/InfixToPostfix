package stack;

public class Stack<T>
{
	Node<T> startOfList = new Node<T>();
	
	protected Stack()
	{
		startOfList.setLink(null);
	}
	
	protected boolean listIsEmpty()
	{
		if (startOfList.getLink() == null)
			return true;
					
		return false;
	}
	
	protected void push(T information)
	{
		Node<T> newNode = new Node<T>();
		newNode.setInfo(information);

		newNode.setLink(startOfList);
		startOfList = newNode;
	}
	
	protected void pop() throws StackUnderflowException
	{
		
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to remove");
		else
			startOfList = startOfList.getLink();
	}
	
	protected T top() throws StackUnderflowException
	{
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to check");
		else
			return startOfList.getValue();
	}
}
