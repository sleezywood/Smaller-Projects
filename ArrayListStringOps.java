/*
ArrayListStringOps.java
ICS4U - Solving Varied Questions using ArrayLists
Sudhanya Golla
Created July 5th, 2024
Last Modified July 5th 2024
*/

// Java setup
import java.util.*;

	
class ArrayListStringOps {
	static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
	  Random rand = new Random();
	  Scanner in = new Scanner(System.in);

	  // Question 1 - gather students and numbers of extracurriculars they do
	  ArrayList<String> studentsName = new ArrayList<String>();
	  ArrayList<Integer> extracurricularList = new ArrayList<Integer>();

	  // Gather student input
	  // Student has to input 2 names at first (second name counts)
	  studentInput(studentsName, extracurricularList);

	  boolean validinput = false;

	  while (validinput == false)
	  {

		// Prompt user for next decisions
	  	System.out.println("\nYou have finished adding people. Do you want to do anything else?\n(1) to view a specific individual and their extracurriculars\n(2) to add an individual and their extracurriculars\n(3) to remove all students and extracurriculars\n(4) to remove a certain individual and their extracurriculars\n(0) To quit the program.");
	  	int choiceInput = in.nextInt();

		// Provide user a certain action based on their input
		if (choiceInput == 2)
		{
			validinput = true;
			// Allow user to add more students and extracurricular
			studentInput(studentsName, extracurricularList);
		}
			
		// Allow user to find and output individual
		else if (choiceInput == 1)
		{
			validinput = true;
			viewIndividual(studentsName, extracurricularList, true);
		}

		// Allow user to remove individual if they exist
		else if (choiceInput == 4)
		{
			validinput = true;
			removeIndividual(studentsName, extracurricularList);
		}

		// Clear everyone
		else if (choiceInput == 3)
		{
			validinput = true;
			studentsName.clear();
			extracurricularList.clear();
			System.out.println("All students and respective extracurriculars removed.");
		}
		// End program
		else if (choiceInput == 0)
		{
			validinput = true;
			System.out.println("Program Ended.");
			break;
		}
		else
		{
			System.out.println("Invalid input.");
		}

	  }


	  // Question 2 - Gather hockey players and statistics
	  int userHockey = 4;
	  ArrayList<String> playerNames = new ArrayList<String>();
	  ArrayList<Integer> pointsList = new ArrayList<Integer>();
	  boolean foundIndex = false;
	  int indexLoc = 0;
	  int indexLoc2 = 0;

	  // Allow user to perform tasks after input
	  while (userHockey == 4)
	  {
	  
		  // Gather user input
		  inputPlayer(playerNames, pointsList);
	  
		  System.out.println("Do you want to do anything else?\n(1) to view a specific person's stats\n(2)Allow one to adjust their points\n(3)Remove a traded player\n(4)Clear and restart program");
		  userHockey = in.nextInt();

		  // Allow them to view a certain individual and their statistics
		  if (userHockey == 1)
		  {
			  viewIndividual(playerNames, pointsList, false);
		  }
			  
		  else if (userHockey == 2)
		  {
			  
			   // Allow user to adjust score of certain player
			  System.out.println("Enter adjusted score:");
			  int changePoints = in.nextInt();
			  System.out.println("Which person's points do you want to adjust?");
			  in.nextLine();
			  String name = in.nextLine();

			  // Find lcation of person if their name is retrievable
			  for (int indexPlay = 0; indexPlay < playerNames.size(); indexPlay++)
			  {
				  // Get location if player exists
				  if (playerNames.get(indexPlay).equals(name))
				  {
					  indexLoc = indexPlay;
					  foundIndex = true;
				  }
			  }

			  // Output final statement
			  // Output changed stat to user if player is retrieved
			  if (foundIndex == true)
			  {
				  System.out.println(name + " now has " + changePoints + " points scored for the entire season.");
			  }
				  
			  // If player was not retrieved output that player was not found
			  else
			  {
				  System.out.println("Player not found");
			  }
	
		  }

		  // Determine whether there was a traded player
		  else if (userHockey == 3)
		  {
			  System.out.println("Is there a player that is traded?");
			  in.nextLine();
			  String tradeName = in.nextLine();

			  // Find location of player within the array
			  for (int indexTrade = 0; indexTrade < playerNames.size(); indexTrade++)
			  {
				  
				  // If retievable, get location value
				  if (playerNames.get(indexTrade).equals(tradeName))
				  {
					  indexLoc2 = indexTrade;
					  foundIndex = true;
				  }
			  }

			  // If player is found, remove them and their statistics from team
			  // Output that they were removed
			  if (foundIndex == true)
			  {
				  System.out.println(tradeName + " is now removed.");
				  playerNames.remove(playerNames.get(indexLoc2));
				  pointsList.remove(pointsList.get(indexLoc2));
				  
			  }

			  // Output that player is not found if they are irretrivable
			  else
			  {
				  System.out.println("Player not found");
			  }
			  
		  }

		  // Clear all people and start over again
		  else if (userHockey == 4)
		  {
			  playerNames.clear();
			  pointsList.clear();
			  System.out.println("All people and points cleared");
		  }
		  
	  }

	  // Question 3 - Parse a string given a range of positions
	  // For this code, 1 is the starting position, and end position is final position of last character on the string
	  // Last position user requests will also be printed onto terminal
	  int firstNum = 0;
	  int lastNum = 0;
	  boolean validNumbers = false;
	  System.out.println("Enter a sentence: ");
	  String sentence = in.nextLine();

	  // Output what user will expect to enter
	  System.out.println("You will enter a range of numbers (from 1 to the last position of a character in the sentence)");

	  // Make sure user input is eventually valid
	  // Prompt user to enter a range of numbers
	  while (validNumbers == false)
	  {
	  System.out.println("Enter the beginning number: ");
	  firstNum = in.nextInt();
	  System.out.println("Enter the ending number: ");
	  lastNum = in.nextInt();

	  // Validate range
	  // Make sure first value does not exceed next value
	  if (firstNum >= lastNum)
	  {
		  System.out.println("First number is greater than or equal to the last number. The range is invalid");
	  }

	  // Make sure number is not out of bounds
	  else if (firstNum > sentence.length())
	  {
		  System.out.println("Number is out of bounds");
	  }
	  else if (lastNum > sentence.length())
	  {
		  System.out.println("Number is out of bounds");
	  }
	  else if (firstNum < 0)
	  {
		  System.out.println("Number is out of bounds");
	  }
	  else if (lastNum < 0)
	  {
		  System.out.println("Number is out of bounds");
	  }

	  // Else, numbers are valid
	  else
	  {
		  validNumbers = true;
	  }
	  }

	  // Modify numbers for index
	  firstNum--;

	  // Parse string and output final statement
	  String finalPartString = sentence.substring(firstNum, lastNum);
	  System.out.println("Your final string is " + finalPartString);

	  // Question 4 - determine the amount of times a character occurs within a word
	  // Prompt user for word and character
	  System.out.println("Enter word: ");
	  in.nextLine();
	  String word = in.nextLine();
	  System.out.println("Enter character: ");
	  String character = in.nextLine();
	  int countChar = 0;

	  // Determine how many times the inputted character occurs within the word
	  for (int numChar = 0; numChar < word.length(); numChar++)
	  {

		  // Keep track of how many times the character occurs within the word
		  if (word.substring(numChar, (numChar +1)).equals(character))
		  {
			  countChar++;
		  }
		  
	  }

	  // Output total amount of times inputted character occurs within the word
	  if (countChar != 0)
	  {
		  System.out.println("The character " + character + " occurs " + countChar + " times.");
	  }

	  // If not, output that there were no occurences
	  else
	  {
		  System.out.println("The character does not occur within the sentence");
	  }

	  // Question 5 - Determine whether inputted number is a palindrome
	  // Prompt user for a number
	  String reversedNum = "";
	  System.out.println("Enter a number: ");
	  String numberInput = in.nextLine();

	  // Determine what the reversed number is
	  for (int indexStrNum = numberInput.length(); indexStrNum >= 1; indexStrNum --)
		  {
			  reversedNum += numberInput.substring(indexStrNum -1, indexStrNum);
		  }

	  // Output final statement if both original and reversed number are the same
	  if (reversedNum.equals(numberInput))
	  {
		  System.out.println("The number is a palindrome");
	  }
	  else
	  {
		  System.out.println("The number is not a palindrome");
		  System.out.println("Reversed number: " + reversedNum);
	  }
	  
  }
	
	// Subprograms for question 1
	// Allow user to input 
	public static void studentInput(ArrayList<String>studentsName, ArrayList<Integer>extracurricularList)
	{
		String userInput = "";

		// Prompt user until they enter done
		while (!userInput.equals("done"))
	    {
		  System.out.println("Enter Student's name: (enter done when finished)");
		 
		  String userInput1 = in.nextLine().trim();
		  userInput = userInput1.toLowerCase();

		  // Do not count "done" as a person to ensure realism
		  if (userInput.equals("done"))
		  {
			  break;
		  }

		  // Prompt user's extracurriculars
		  System.out.println("Enter number of student " + userInput1 +"'s extracurriculars");
		  extracurricularList.add(in.nextInt());
		  studentsName.add(userInput1);
		  in.nextLine();
	    }
		
	}

	  // Allow user to view individual after putting in their name
	  public static void viewIndividual(ArrayList<String>studentsName, ArrayList<Integer>extracurricularList, boolean isQuestion1)
	  {
		  // Prompt user for person
		  Scanner in = new Scanner(System.in);
		  System.out.println("Which person do you want to search for");
		  String search = in.nextLine().trim();
		  boolean isFound = false;
		  int index = 0;

		  // Gather index of location of user, if it exists
		  for (int indexInd = 0; indexInd < studentsName.size(); indexInd++)
		  {
			  if (studentsName.get(indexInd).equals(search))
			  {
				  index = indexInd;
				  isFound = true;
			  }
			  
		  }

		  // Output whether student is found or not
		  // If student found, output student and their extracurriculars
		  if (isFound == false)
		  {
			  System.out.println("Person is not found");
		  }
		  else
		  {
			  
			  if (isQuestion1 == true)
			  {
				  System.out.println("Student's name is " + studentsName.get(index) +", and they have " + extracurricularList.get(index) + " extracurriculars.");
			  }
			  else
			  {
				  System.out.println("Player name is " + studentsName.get(index) + " and they have " + extracurricularList.get(index) + " points.");
			  }

		  }

	  }

	  // Remove individual if found
	  public static void removeIndividual(ArrayList<String>studentsName, ArrayList<Integer>extracurricularList)
	  {
		  // Prompt user for person
		  Scanner in = new Scanner(System.in);
		  System.out.println("Which person do you want to remove?");
		  String remove = in.nextLine().trim();
		  boolean canRemove = false;

		  // Find location of person if they exist
		  for (int searchInd = 0; searchInd < studentsName.size(); searchInd++)
		  {
			  if (studentsName.get(searchInd).equals(remove))
			  {
				  studentsName.remove(studentsName.get(searchInd));
				  canRemove = true;
			  }

		  }

		  // Output statement based on whether person exists 
		  if (canRemove == true)
		  {
			  System.out.println("Student found and removed.");
		  }
		  else
		  {
			  System.out.println("Student not found");
		  }

	   }

	// Subprogram for question 2
	public static void inputPlayer(ArrayList<String>playerNames, ArrayList<Integer>pointsList)
	{
	  System.out.println("How many people are on a soccer team?");
	  int numPeople = in.nextInt();

	  for (int people = 0; people < numPeople; people ++)
	  {
		  System.out.println("Enter person's " + (people + 1) + " stats for the season:");
		  int points = in.nextInt();
		  System.out.println("Enter person's " + (people + 1) + " name:");
		  in.nextLine();
		  String person = in.nextLine();

		  playerNames.add(person);
		  pointsList.add(points);
	  }
	}
	
}