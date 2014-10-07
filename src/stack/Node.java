package stack;

public class Node<T>
{
	T value;
	
	protected Node<T> link;
	
	protected Node()
	{
		link = null;
	}
	
	protected T getValue()
	{
		return value;
	}
	
	protected void setInfo(T information)
	{
		value = information;
	}
	
	protected Node<T> getLink()
	{
		return link;
	}
	
	protected void setLink(Node<T> link)
	{
		this.link = link;
	}
}
