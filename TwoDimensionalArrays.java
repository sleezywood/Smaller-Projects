/*
TwoDimensionalArrays.java
Solving Questions using 2D Arrays
Sudhanya Golla
Created July 4th, 2024
Last Modified July 4th, 2024
*/

// Java setup
import java.util.Scanner;
import java.util.Random;

class TwoDimensionalArrays {
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  Random rand = new Random();

	  // Question 1 - print a 10 x 10 2D array
	  int integers[][] = new int[10][10];

	  // Print 10 numbers per row
	  for (int row = 0; row < 10; row ++)
	  {
		  // Randomize and print 10 numbers per column
		  for (int col = 0; col < 10; col ++)
		  {
			  int randomNum = rand.nextInt(1, 101);
			  integers[row][col] = randomNum;
			  System.out.print(integers[row][col] + " ");
		  }
		  // Separate each row from each other
		  System.out.println("");
	  }

	  // Question 2 - print and find the largest and smallest value
	  int intArray[][] = {{16, 22, 99, 4, 18},
						  {-2, 4, 103, 5, 95},
						  {117, 6, 15, 2, 45},
						  {-33, 45, 87, 77, 12},
						  {32, -33, -6, 91, 56}};
	  int largestNum = intArray[0][0];
	  int smallestNum = intArray[0][0];

	  System.out.print("\nThe grid is as follows: \n");

	  // Output printed grid
	  for (int row2 = 0; row2 < 5; row2 ++)
	  {
		  for (int col2 = 0; col2 < 5; col2 ++)
		  {
			  System.out.print(intArray[row2][col2] + " ");

			  // Determine largest number
			  if (largestNum < intArray[row2][col2])
			  {
				  largestNum = intArray[row2][col2];
			  }

			  // Determine smallest number
			  if (smallestNum > intArray[row2][col2])
			  {
				  smallestNum = intArray[row2][col2];
			  }
			  
		  }
		  // Make sure each row is separated by a line
		  System.out.println("");
	  }

	  // Output smallest and largest values
	  System.out.println("\nThe smallest value is " + smallestNum + ", and the largest value is " + largestNum + ".\n");

	  // Question 3
	  int score = 0;
	  int totalScore = 0;
	  int[]playerScores1 = new int[3];
	  int[]playerScores2 = new int[3];
	  int[]playerScores3 = new int[3];
	  int[]playerScores4 = new int[3];
	  int[]playerScores5 = new int[3];
	  int[]totalScores = new int[5];

	  int[][]scores = {playerScores1, playerScores2, 
					   playerScores3, playerScores4, 
					   playerScores5};

	  // Determine score for every player
	  for (int rowPlayer = 0; rowPlayer < scores.length; rowPlayer++)
	  {
		  totalScore = 0;

		  // Determine score for each game a player plays
		  // Determine total score for each person
		  for (int colPlayer = 0; colPlayer < 3; colPlayer ++)
		  {
			  boolean validScore = false;
			  while (validScore == false)
			  {
				  System.out.println("Enter score " + (colPlayer + 1) + " for player " + (rowPlayer + 1));
				  score = in.nextInt();

				  // Validate score inputted by user
				  // Score can only be in between 0 and 300 for any time one bowls
				  if (score < 0)
				  {
					  System.out.println("Score is invalid");
				  }
				  else if (score > 300)
				  {
					  System.out.println("Score is invalid");
				  }
				  else
				  {
					  validScore = true;
				  }
			  }
			  scores[rowPlayer][colPlayer] = score;
			  totalScore += score;
			  totalScores[rowPlayer] = totalScore;
		  }
	  }

	  // Find who has the most amount of points
	  findWinner(totalScores, true);

	  // Question 4
	  int bookCheck = 0;
	  int[]book1 = new int[4];
	  int[]book2 = new int[4];
	  int[]book3 = new int[4];
	  int[]book4 = new int[4];
	  int[]book5 = new int[4];
	  int[]book6 = new int[4];

	  int[][]totalBooks = {book1, book2, book3, book4, book5, book6};
	  int[]totalBookPerson = new int[6]; 

	  // Determine books checked out for each person
	  for (int rowBook = 0; rowBook < totalBooks.length; rowBook ++)
	  {
		  int totalBook = 0;

		  // Determine books checked out for each week
		  // Find out the total amount of books signed out for each person
		  for (int colBook = 0; colBook < 4; colBook ++)
		  {
			  boolean validBook = false;
			  while (validBook == false)
			  {
				  System.out.println("Enter number of books checked out for person " + (rowBook + 1) + " for week " + (colBook + 1) + ": ");
				  bookCheck = in.nextInt();

				  // Validate number of books inputted
				  if (bookCheck < 0)
				  {
					   System.out.println("Invalid input of books");
				  }
				  else
				  {
					  validBook = true;
				  }
			  }
			  
			  totalBooks[rowBook][colBook] = bookCheck;
			  totalBook += bookCheck;
			  totalBookPerson[rowBook] = totalBook;
		  }
	  }

	  // Determine who checked out the most books
	  findWinner(totalBookPerson, false);
	  
  }

	// Subprogram for question 3 and 4
	// Determine who had the most points/books
	public static void findWinner(int[]totalScores, boolean isQuestion3)
	{
	  int highestScore = totalScores[0];
	  int player = 0;

	  // Determine the highest value between all people
	  System.out.println("");
	  for (int colScores = 0; colScores < totalScores.length; colScores++)
	  {
		  if (highestScore < totalScores[colScores])
		  {
			  highestScore = totalScores[colScores];
			  player = colScores + 1;
		  }

		  // Output player's total points if situation pertains to question 3
		  // Else, output person's total books checked if situation pertains to question 4
		  if (isQuestion3 == true)
		  {
			  System.out.println("Player " + (colScores + 1) + " has " + totalScores[colScores] + " points.");
		  }
		  else
		  {
			  System.out.println("Player " + (colScores + 1) + " has " + totalScores[colScores] + " books checked out.");
		  }
		  }

	  // Output winner if question pertains to question 3
	  // If not, output person who checked out the most amount of books if question pertains to question 4
	  if (isQuestion3 == true)
	  {
		System.out.println("\nThe winner is player " + player + ", who has " + highestScore + " points.");
	  }
	  else
	  {
		  System.out.println("\nThe maximum amount of checkouts is done by person " + player + ", who has " + highestScore + " books checked out.");
	  }
	  	
	}
}