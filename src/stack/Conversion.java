package stack;

public class Conversion
{
	static Stack<Character> operatorStack = new Stack();
	
	private static final int TOTAL_NUMBER_OF_OPERATORS = 10;
	
	public static String postfixExpression;
	
	public static void convertToPostfix(char [] infixCharArray) throws StackUnderflowException
	{
		StringBuilder postfixString = new StringBuilder();
		for (int characterCounter = 0; characterCounter < infixCharArray.length; characterCounter++)
		{
			if (isOperator(infixCharArray, characterCounter))
				processOperator(infixCharArray, characterCounter, postfixString);
			
			else if (infixCharArray[characterCounter] == '(')
				operatorStack.push(infixCharArray[characterCounter]);
			
			else if (infixCharArray[characterCounter] == ')')
				processRightParen(infixCharArray, characterCounter, postfixString);
			
			else 
			{
				postfixString.append(infixCharArray[characterCounter]);
				if (!Character.isDigit(infixCharArray[characterCounter + 1]))
					postfixString.append(" ");
			}
			
		}
		postfixExpression = postfixString.toString();
		postfixExpression = postfixExpression.trim();
	}
	public static boolean isOperator(char[] infixCharArray, int characterCounter)
	{
		char [] operatorList = {'+' , '-', '*', '/', '^', 'Q', 'C', '<', '>', '%'};
		for (int operatorNumber = 0; operatorNumber < TOTAL_NUMBER_OF_OPERATORS; operatorNumber++)
		{
			if (infixCharArray[characterCounter] == operatorList[operatorNumber])
				return true;
		}
		return false;
	}
	
	public static void processOperator(char[] infixCharArray, int characterCounter,
									   StringBuilder postfixString
									  ) throws StackUnderflowException
	{
		while(!operatorStack.listIsEmpty() && (operatorStack.top() != '('))
		{
			char topStackOperator = operatorStack.top();
			operatorStack.pop();
			postfixString.append(topStackOperator + " ");
		}
		operatorStack.push(infixCharArray[characterCounter]);
	}
	
	public static void processRightParen(char[] infixCharArray, int characterCounter,
										 StringBuilder postfixString
										) throws StackUnderflowException
	{
		while (operatorStack.top() != '(')
		{
			postfixString.append(operatorStack.top() + " ");
			operatorStack.pop();
		}
		operatorStack.pop();
	}
}
