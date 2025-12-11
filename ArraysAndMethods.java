/*
ArraysAndMethods.java
Solving Questions using Arrays and Methods
Sudhanya Golla
Created July 3rd, 2024
Last Modified July 3rd, 2024
*/

// Java setup
import java.util.Scanner;
import java.util.Random;

public class ArraysAndMethods {

  public static void main(String[] args)
  {
	  Scanner in = new Scanner(System.in);

	  Random rand = new Random();
	  
	  double[]marksList = new double[10];

	  // Question 1 - Gather 10 marks from user and store them for future use
	  for (int repeat = 0; repeat < 10; repeat++)
	  {
		  System.out.println("Enter marks of student " + (repeat + 1) + ": ");
		  double studentMark = in.nextDouble();
		  marksList[repeat] = studentMark;
	  }

	  // Output marks gathered in order, backwards, and average grade
	  printForwards(marksList);
	  printBackwards(marksList, 10);
	  double averageMark = determineAverage(marksList);
	  System.out.println("\nThe average grade is " + averageMark);

	  // Question 2
	  int[]hundredArray = new int[100];	  
	  createArray(hundredArray);

	  // Prompt user to perform tasks upon the array
	  System.out.println("Your array is created. What do you want to do with it?");

	  boolean userFinishedQuest3 = false;

	  // Prompt user as many times as they want
	  while (userFinishedQuest3 == false)
	  {
		  System.out.println("\n(1) to print it out forwards\n(2) to get a value at a certain index\n(3) at a random index\nAny other number to exit the program");
		  int input = in.nextInt();
			  
		  // Perform task on array depending upon what user inputs
		  if (input == 1)
		  {
			  readArrayForwards(hundredArray);
		  }
		  else if (input == 2)
		  {
			  boolean validNumber = false;
	
			  // Make sure inputted index is eventually valid
			  while (validNumber == false)
			  {
				  System.out.println("Which index do you want to find the value of?");
				  int indexNumber = in.nextInt();
	
				  // Validate index
				  if (indexNumber < 0)
				  {
					  System.out.println("Cannot have a number below 0");
				  }
				  else if (indexNumber > 99)
				  {
					  System.out.println("Cannot have a number above 99");
				  }
				  // If valid, output value of item that contains specified index
				  else
				  {
					  validNumber = true;
					  findIndex(hundredArray, indexNumber);
				  }
			  }
			  
		  }
		  // Find a random index and output value of index
		  else if (input == 3)
		  {
			  int randomIndex = rand.nextInt(100);
			  findIndex(hundredArray, randomIndex);
		  }
		  // Exit program otherwise
		  else
		  {
			  userFinishedQuest3 = true;
			  System.out.println("Have a good day");
		  }

	  }
	  
	  // Question 3 - Find factorial of number
	  boolean validFactorial = false;

	  //Make sure user eventually inputs a valid answer
	  while (validFactorial == false)
	  {
		  System.out.println("What number do you want to find the factorial of?");
		  int factorial = in.nextInt();

		  // Validate number
		  // Output final answer if number is valid
		  if (factorial < 0)
		  {
			  System.out.println("Cannot input a number less than 0");
		  }
		  else
		  {
			  validFactorial = true;
			  int answer = findFactorial(factorial);
			  System.out.println(factorial + "! is " + answer);
		  }
	  }
	  
	 // Question 4 - Get integers and determine whether they are even or odd
	 boolean validAnswer = false;
	 int evenNum = 0;
	 int oddNum = 0;
	 int totalNum = 0;

	 // Make sure user input is eventually valid
	 while (validAnswer == false)
	 {	 
		 System.out.println("\nHow many numbers do you want?");
		 int integer = in.nextInt();

		 // Validate user input
		 if (integer <= 0)
		 {
			 System.out.println("Cannot have less than or equal to 0 numbers");
		 }
		 else
		 {
			 validAnswer = true;
			 int[]numberArray = new int[integer];

				 // Ramdomize values for each item in array
				 for (int items = 0; items < integer; items++)
				 {
					 numberArray[items] = rand.nextInt(-101, 101);

					 // Determine whether each value is even or odd
					 boolean conclusion = isEven(numberArray[items]);

					 // Determine how many even and odd numbers there were
					 if (conclusion == true)
					  {
							System.out.println("Number " + numberArray[items] + " is even.");
							evenNum ++;
					  }
					 else if (conclusion == false)
					 {
							System.out.println("Number " + numberArray[items] + " is odd.");
							oddNum ++;
					  }
							 
					 totalNum ++;
				 }

			// Output total number of odd, even, and total numbers 
			System.out.println("\nYou have " + evenNum + " even numbers, " + oddNum + " odd numbers, and " + totalNum + " total numbers." );
			 
		  }
	 }
  }

  // Subprograms for Question 1
  // Print marks in a forwards manner
  public static void printForwards(double[]marksList)
  {  
	  System.out.println("\nPeople's marks forwards: ");

	  // Print out each person's individual marks
	  for (int marks = 0; marks <10; marks++)
	  {
		  System.out.print(marksList[marks] + ", ");
	  }
	  
  }

  // Print everyone's marks backwards
  public static void printBackwards(double[]marksList, int indexMark)
  {
	  double[]marksReverse = new double[indexMark];
	  int reverse = indexMark;

	  // Store each person's mark starting from the last person
	  for (int index = 0; index < indexMark; index++)
	  {
			marksReverse[reverse-1] = marksList[index];
			reverse = reverse - 1;
	  }

	  // Print each person's mark starting from the last person
	  // Output final statement
	  System.out.println("\nMarks backwards are: ");
	
	  for (int indexReverse = 0; indexReverse < indexMark; indexReverse++)
	  {
          System.out.print(marksReverse[indexReverse] + ", ");
	  }
	  
  }

  // Determine average of all people combined
  public static double determineAverage(double[]marksList)
  {
		double total = 0;
		double average = 0;

		// Find the total of everyone's mark
		for (int eachMark = 0; eachMark < marksList.length; eachMark++)
		{
				total = total + marksList[eachMark];
		}

	    // Calculate average from total
		average = total/10;
		return average;
  }

  // Subprograms for question 2
  // Create an array
  public static int[] createArray(int[]hundredArray)
  {
	    Random rand = new Random();

		// Randomize values and assign it to any value in the array
		for (int random = 0; random < 100; random++)
		{
			int randomInt = rand.nextInt(1, 101);
			hundredArray[random] = randomInt;
		}

	    return hundredArray;
  }

  // Read it forwards
  public static void readArrayForwards(int[]hundredArray)
  {
		System.out.println("\nFull array forwards is: ");

	    // Print out every single item within the array
		for (int read = 0; read < 100; read++)
		{
			System.out.print(hundredArray[read] + ", ");
		}
  }

  // Gather value of item at a specified index
  public static void findIndex(int[]hundredArray, int index)
  {
	  // Get and print value
	  int finalValue = hundredArray[index];
	  System.out.println("Array value at index " + index + " is " + finalValue);
  }

  // Subprogram for question 3 - Find factorial of given number
  public static int findFactorial(int factorialNum)
  {
	  int number = 1;

	  // Calculate the factorial of given number
	  for (int start = 1; start <= factorialNum; start++)
		{
			number *= start;
		}

	  return number;
	  
  }

  // Subprogram for question 4 - Determine whether integer is even
  public static boolean isEven(int integer)
  {
	  boolean isEven = false;

	  // Check whether it is even or odd based on its remainder after dividing by 2
	  if (integer % 2 != 0)
	  {
		  isEven = false;
	  }
	  else if (integer % 2 == 0)
	  {
		  isEven = true;
	  }

	  return isEven;
  }

}