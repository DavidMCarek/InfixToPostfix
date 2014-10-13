// EECS 2500
// David Carek
// Infix to Postfix project

// This program prompts the user for an infix expression. The expression is then sent to the 
// converter that changes the expression into a postfix one. The postfix expression is then 
// printed out and sent to the evaluater. The evaluater then updates the evaluated expression 
// which is printed out in main.

package stack;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		String infixExpression;
		
		
		// The objects needed are constructed so that the classes methods and variables can be 
		// referenced without using static and a scanner is instantiated to take in input from
		// the user
		EvaluatePostfixExpression Evaluater = new EvaluatePostfixExpression();
		Conversion Converter = new Conversion();
		Scanner input = new Scanner(System.in);
		do
		{
			// Input is taken in from the user and spaces are also removed so that the converter
			// does not have to ignore them. The text is made upper case to deal with the user
			// inputting lower q or c and the word exit. 
			System.out.println("Please input an infix expression or type Exit to end the program: ");
			infixExpression = input.nextLine();
			
			infixExpression = infixExpression.replaceAll(" ", "");
			infixExpression = infixExpression.toUpperCase();
				
			try
			{
				// If the user enters exit the program will end.
				if (!infixExpression.equals("EXIT"))
				{
					char [] infixCharArray = infixExpression.toCharArray();
					
					// Postfix expression is updated.
					Converter.convertToPostfix(infixCharArray);			
				
					System.out.println(Converter.postfixExpression);
					
					// Evaluated expression is updated
					Evaluater.evaluateTheExpression(Converter.postfixExpression);
					
					// If an arithmetic overflow didn't occur the evaluated expression
					// is displayed. If not Arithmetic Overflow is printed.
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
				// The message of the error is displayed.
				System.out.println(StackUnderflowException.getMessage());
			}
		}while(!infixExpression.equals("EXIT"));
		input.close();
	}
}
