package stack;

public class Node<T>
{
	T value;
	
	private Node<T> link;
	
	public Node()
	{
		link = null;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setInfo(T information)
	{
		value = information;
	}
	
	public Node<T> getLink()
	{
		return link;
	}
	
	public void setLink(Node<T> link)
	{
		this.link = link;
	}
}
