package stack;

public class Conversion
{
	protected Conversion()
	{
	}
	
	Stack<Character> operatorStack = new Stack();
	
	private final int TOTAL_NUMBER_OF_OPERATORS = 10;
	
	private char [] operatorList = {'>', '<', '-', '+' , '%', '/', '*', '^', 'C', 'Q'};
	
	protected String postfixExpression;
	
	protected void convertToPostfix(char [] infixCharArray) throws StackUnderflowException
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
				if ((characterCounter + 1 < infixCharArray.length) &&
					!Character.isDigit(infixCharArray[characterCounter + 1]))
					postfixString.append(" ");
				
				if (characterCounter + 1 == infixCharArray.length)
					postfixString.append(" ");
			}
			
		}
		
		while (!operatorStack.listIsEmpty())
		{
			postfixString.append(operatorStack.top() + " ");
			operatorStack.pop();
		}
			
		
		postfixExpression = postfixString.toString();
		postfixExpression = postfixExpression.trim();
	}
	private boolean isOperator(char[] infixCharArray, int characterCounter)
	{
		for (int operatorNumber = 0; operatorNumber < TOTAL_NUMBER_OF_OPERATORS; operatorNumber++)
		{
			if (infixCharArray[characterCounter] == operatorList[operatorNumber])
				return true;
		}
		return false;
	}
	
	private void processOperator(char[] infixCharArray, int characterCounter,
									   StringBuilder postfixString
									  ) throws StackUnderflowException
	{
		while(!operatorStack.listIsEmpty() &&
			 (operatorStack.top() != '(') &&
			 (precedenceOfNewOperatorLessThanStackTop(infixCharArray, characterCounter)))
		{
			char topStackOperator = operatorStack.top();
			
			operatorStack.pop();
			postfixString.append(topStackOperator + " ");
		}
		
		operatorStack.push(infixCharArray[characterCounter]);
	}
	
	private void processRightParen(char[] infixCharArray, int characterCounter,
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
	private boolean precedenceOfNewOperatorLessThanStackTop(char [] infixCharArray, int characterCounter) throws StackUnderflowException
	{
		int precedenceOfCurrentOperator = 0;
		int precedenceOfStackTopOperator = 0;
		
		for (int operatorCount = 0; operatorCount < TOTAL_NUMBER_OF_OPERATORS; operatorCount++)
		{
			if (infixCharArray[characterCounter] == operatorList[operatorCount])
				precedenceOfCurrentOperator = operatorCount;
			
			if (operatorStack.top() == operatorList[operatorCount])
				precedenceOfStackTopOperator = operatorCount;
			
		}
		if (precedenceOfCurrentOperator <= precedenceOfStackTopOperator)
			return true;
		
		return false;
	}
}
