package stack;

public class StackUnderflowException extends RuntimeException
{
	protected StackUnderflowException()
	{
		super();
	}
	
	protected StackUnderflowException(String underflowMessage)
	{
		super(underflowMessage);
	}
	
}
