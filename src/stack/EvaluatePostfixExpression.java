package stack;

public class EvaluatePostfixExpression
{
	protected EvaluatePostfixExpression()
	{
	}
	
	Stack<Long> valuesStack = new Stack<Long>();
	
	public boolean arithmeticOverflow;
	
	long evaluatedExpression;
	
	// This method will evaluate the postfix expression and update the evaluatedExpression variable.
	protected void evaluateTheExpression(String postfixExpression) throws StackUnderflowException
	{
		String postfixString = postfixExpression;
		
		// The space is used as a delimiter to split the postfix expression into an array of strings.
		String [] postfixStringArray = postfixString.split(" ");
		
		// The loop increments through each of the slots in the array and checks to see if the slot
		// is an operator. If the slot is an operator the operation is performed. Else the slot 
		// contains a number and should be pushed on to the stack.
		for (int postfixPlaceCounter = 0; postfixPlaceCounter < postfixStringArray.length; postfixPlaceCounter++)
		{
			if (postfixStringArray[postfixPlaceCounter].equals("Q"))
			{
				double firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((long) Math.sqrt(firstValue));
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("C"))
			{
				double firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((long) Math.cbrt(firstValue));
			}
			else if (postfixStringArray[postfixPlaceCounter].equals("<"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();
				
				valuesStack.push((long) firstValue << secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals(">"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((long) firstValue >> secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("^"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();				
				valuesStack.push((long) Math.pow(firstValue, secondValue));
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("*"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();				
				valuesStack.push((long) firstValue * secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("/"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();				
				valuesStack.push((long) firstValue / secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("%"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();			
				valuesStack.push((long) firstValue % secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("+"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();			
				valuesStack.push((long) firstValue + secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("-"))
			{
				long secondValue = valuesStack.top();
				valuesStack.pop();
				long firstValue = valuesStack.top();
				valuesStack.pop();			
				valuesStack.push((long) firstValue - secondValue);
			}
			
			else
			{	
				valuesStack.push(Long.parseLong(postfixStringArray[postfixPlaceCounter]));
			}
			
		}
		evaluatedExpression = valuesStack.top();
		
		arithmeticOverflow = false;
		checkForOverflow();
		
		valuesStack.pop();
	}
	
	// This method updates the variable arithmeticOverflow so that it can be refered to in main.
	// If the evaluated expression (type long) is greater than the max integer value overflow
	// is set to true.
	protected void checkForOverflow()
	{
		if (evaluatedExpression > Integer.MAX_VALUE)
			arithmeticOverflow = true;
		
		else
			arithmeticOverflow = false;
	}
}
