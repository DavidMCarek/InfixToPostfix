package stack;

public class EvaluatePostfixExpression
{
	public final static int TOTAL_NUMBER_OF_OPERATORS = 10;
	
	static Stack<Integer> valuesStack = new Stack();
	
	static String postfixString = Conversion.postfixExpression;
	
	static String [] postfixStringArray = postfixString.split(" ");
	
	public static int evaluateTheExpression() throws StackUnderflowException
	{
		int evaluatedExpression;
		for (int postfixPlaceCounter = 0; postfixPlaceCounter < postfixStringArray.length; postfixPlaceCounter++)
		{
			
			if (postfixStringArray[postfixPlaceCounter].equals("Q"))
			{
				double firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((int) Math.sqrt(firstValue));
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("C"))
			{
				double firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((int) Math.cbrt(firstValue));
			}
			else if (postfixStringArray[postfixPlaceCounter].equals("<"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue << secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals(">"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue >> secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("^"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push((int) Math.pow(firstValue, secondValue));
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("*"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue * secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("/"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue / secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("%"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue % secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("+"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue + secondValue);
			}
			
			else if (postfixStringArray[postfixPlaceCounter].equals("-"))
			{
				int secondValue = valuesStack.top();
				valuesStack.pop();
				int firstValue = valuesStack.top();
				valuesStack.pop();
				valuesStack.push(firstValue - secondValue);
			}
			
			else
			{	
				valuesStack.push(Integer.parseInt(postfixStringArray[postfixPlaceCounter]));
			}
			
		}
		evaluatedExpression = valuesStack.top();
		valuesStack.pop();
		return evaluatedExpression;
	}
	
}
