package stack;

public class StackUnderflowException extends RuntimeException
{
	protected StackUnderflowException()
	{
		super();
	}
	
	// This constructor allows us to generate a message with the error.
	protected StackUnderflowException(String underflowMessage)
	{
		super(underflowMessage);
	}
}
