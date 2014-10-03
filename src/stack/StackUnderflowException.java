package stack;

public class StackUnderflowException extends Exception
{
	public StackUnderflowException()
	{
		super();
	}
	
	public StackUnderflowException(String underflowMessage)
	{
		super(underflowMessage);
	}
	
}
