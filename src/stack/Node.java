package stack;

// This class is used to define the object Node, its basic methods and characteristics
// that will be used in the creation of the linked list with stack implementation.
// A generic node is used since the node will need to hold chars and longs in two
// different instances.

public class Node<T>
{
	
	T nodeInformation;
	
	protected Node<T> linkToNextNode;
	
	protected Node()
	{
		linkToNextNode = null;
	}
	
	protected T getNodeInfo()
	{
		return nodeInformation;
	}
	
	protected void setNodeInfo(T newInformation)
	{
		nodeInformation = newInformation;
	}
	
	protected Node<T> getNodeLink()
	{
		return linkToNextNode;
	}
	
	protected void setNodeLink(Node<T> link)
	{
		this.linkToNextNode = link;
	}
}
