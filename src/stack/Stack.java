package stack;

// This class uses a linked list to implement the functionality of a stack. 
// The stack is of generic type so that it can be used as a char stack for 
// the operators and a long stack for evaluating the expression.

public class Stack<T>
{
	// This node is created as a sort of place holder at the end of the list.
	Node<T> startOfList = new Node<T>();
	
	protected Stack()
	{
	}
	
	// Since there is a place holder node with a link and info of null when 
	// checking to see if the list is empty we only need to check the link of 
	// startOfList. If the link is null it is the place holder node. 
	protected boolean listIsEmpty()
	{
		return (startOfList.getNodeLink() == null);
	}
	
	// When using push we are inserting at the beginning of the list.
	protected void push(T information)
	{
		Node<T> newNode = new Node<T>();
		newNode.setNodeInfo(information);

		newNode.setNodeLink(startOfList);
		startOfList = newNode;
	}
	
	// Pop removes the top node off of the stack. If there is no node to pop
	// the method will throw a stack underflow exception.
	protected void pop() throws StackUnderflowException
	{
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to remove");
		else
			startOfList = startOfList.getNodeLink();
	}
	
	// If there is a node on the top of the stack its info will be returned unless
	// there isn't a node to check then a stack underflow exception is thrown
	protected T top() throws StackUnderflowException
	{
		if (listIsEmpty())
			throw new StackUnderflowException("Node not present to check");
		else
			return startOfList.getNodeInfo();
	}
}
