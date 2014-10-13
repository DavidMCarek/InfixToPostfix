package stack;

public class Conversion
{
	protected Conversion()
	{
	}
	
	Stack<Character> operatorStack = new Stack<Character>();
	
	private final int TOTAL_NUMBER_OF_OPERATORS = 10;
	
	// The order of this array is important later because the index = the precedence value.
	// So the higher the index the higher the precedence.
	private char [] operatorList = {'>', '<', '-', '+' , '%', '/', '*', '^', 'C', 'Q'};
	
	protected String postfixExpression;
	
	// This method converts the infix char array, which was converted from the user's input,
	// into a postfix string expression. This expression is not returned, just updated. Once
	// updated it can be referenced through the rest of the program since it is a class variable.
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
				
				// To decide whether or not there should be a space after the digit, 
				// the next character is checked to see what type it is. If its not a
				// digit a space is added after the number. This allows us to add properly 
				// display numbers of more than one digit.
				if ((characterCounter + 1 < infixCharArray.length) &&
					!Character.isDigit(infixCharArray[characterCounter + 1]))
					postfixString.append(" ");
				
				// When the end of the character array is reached there is occasionally 
				// an operator still left on the stack. This will add a space before the
				// operator. If this issue were handled in the while loop right below
				// there would be a double space error.
				if (characterCounter + 1 == infixCharArray.length)
					postfixString.append(" ");
			}
			
		}
		
		// If there are left over operators on the stack they should be appended and popped
		// off of the stack. 
		while (!operatorStack.listIsEmpty())
		{
			postfixString.append(operatorStack.top() + " ");
			operatorStack.pop();
		}
			
		// The postfix string builder is converted to a regular string and trim is used to 
		// remove any extra spaces at the end of the string that result from the while loop
		// above.
		postfixExpression = postfixString.toString();
		postfixExpression = postfixExpression.trim();
	}
	
	// This checks through all of the possible operators and looks to see if the current 
	// character is an operator.
	private boolean isOperator(char[] infixCharArray, int characterCounter)
	{
		for (int operatorNumber = 0; operatorNumber < TOTAL_NUMBER_OF_OPERATORS; operatorNumber++)
		{
			if (infixCharArray[characterCounter] == operatorList[operatorNumber])
				return true;
		}
		return false;
	}
	
	// When an operator is reached in the char array above there are 2 possibilities for
	// what happens next. If the stack is not empty, the next character on the stack is
	// not a left parenthesis, and the precedence of the current operator is less than
	// the precedence of the operator on the stack then the top operator on the stack
	// is appended to the postfix string builder. If the loop does not execute or finishes
	// then the current operator is push onto the stack.
	private void processOperator(char[] infixCharArray, int characterCounter,
								 StringBuilder postfixString
								) throws StackUnderflowException
	{
		while(!operatorStack.listIsEmpty() &&
			 (operatorStack.top() != '(') &&
			 (precedenceOfCurrentOperatorLessThanTopStackOperator(infixCharArray, characterCounter)))
		{
			char topStackOperator = operatorStack.top();
			
			operatorStack.pop();
			postfixString.append(topStackOperator + " ");
		}
		
		operatorStack.push(infixCharArray[characterCounter]);
	}
	
	// Until the next character on the stack is a left parenthesis the top of the stack
	// is appended then popped. Then the stack is popped once more to get rid of the 
	// left parenthesis.
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
	
	// This method checks the precedence of the of the current operator and the operator on
	// the top of the stack. The array of operators is incremented through and the index value
	// is the precedence value. Then the precedence values are compared and if the precedence
	// of the current operator is less the the top stack operator the method returns true.
	private boolean precedenceOfCurrentOperatorLessThanTopStackOperator(char [] infixCharArray,
																		int characterCounter
																	   ) throws StackUnderflowException
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
			return (precedenceOfCurrentOperator <= precedenceOfStackTopOperator);
	}
}
