package stack;

public class EvaluatePostfixExpression
{
	protected EvaluatePostfixExpression()
	{
		
	}
	
	Stack<Long> valuesStack = new Stack();
	
	public boolean arithmeticOverflow;
	
	long evaluatedExpression;
	
	protected void evaluateTheExpression(String postfixExpression) throws StackUnderflowException
	{
		String postfixString = postfixExpression;
		String [] postfixStringArray = postfixString.split(" ");
		
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
	
	protected void checkForOverflow()
	{
		if (evaluatedExpression > Integer.MAX_VALUE)
			arithmeticOverflow = true;
		
		else
			arithmeticOverflow = false;
	}
}
