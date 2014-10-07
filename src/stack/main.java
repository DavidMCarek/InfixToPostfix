package stack;

import java.util.Scanner;

public class main
{
	public static void main(String[] args) throws StackUnderflowException
	{
		String infixExpression;
		
		EvaluatePostfixExpression Evaluater = new EvaluatePostfixExpression();
		Conversion Converter = new Conversion();
		
		do
		{
			Scanner input = new Scanner(System.in);
				
			System.out.println("Please input an infix expression or type Exit to end the program: ");
			infixExpression = input.nextLine();
			infixExpression = infixExpression.replaceAll(" ", "");
			infixExpression = infixExpression.toUpperCase();
				
			try
			{
				if (!infixExpression.equals("EXIT"))
				{
					char [] infixCharArray = infixExpression.toCharArray();
					Converter.convertToPostfix(infixCharArray);
				
					System.out.println(Converter.postfixExpression);
					
					Evaluater.evaluateTheExpression(Converter.postfixExpression);
					
					if (!Evaluater.arithmeticOverflow)
					{
						System.out.println("" + Evaluater.evaluatedExpression);
					}
					else
						System.out.println("Arithmetic Overflow");
				}
			}
			catch(RuntimeException StackUnderflowException)
			{
				System.out.println(StackUnderflowException.getMessage());
			}
		}while(!infixExpression.equals("EXIT"));
	}
}
