package stack;

import java.util.Scanner;

public class main
{
	public static void main(String[] args) throws StackUnderflowException
	{
		String infixExpression;
		
		do
		{
			Scanner input = new Scanner(System.in);
		
			System.out.println("Please input an infix expression or type Exit to end the program: ");
			infixExpression = input.nextLine();
			infixExpression = infixExpression.replaceAll(" ", "");
			infixExpression = infixExpression.toUpperCase();
		
			if (!infixExpression.equals("EXIT"))
			{
				char [] infixCharArray = infixExpression.toCharArray();
		
				Conversion.convertToPostfix(infixCharArray);
	
				System.out.println(Conversion.postfixExpression);
		
				System.out.println("" + EvaluatePostfixExpression.evaluateTheExpression());
			}
		}while(!infixExpression.equals("EXIT"));	
	}
}
