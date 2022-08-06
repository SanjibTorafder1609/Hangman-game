import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hangman1 {
	public static void main(String[] args) throws FileNotFoundException { 		//gets rid of file not found exeption if there is
		Scanner keyboardInput = new Scanner (System.in);
		
		System.out.println("1 or 2 players?");
		String players = keyboardInput.nextLine();
		String word;
		if (players.equals("1")){
			
			//imports a file instead of user input
		Scanner scanner = new Scanner (new File("C:/Users/sagor/OneDrive - University of New Brunswick/Desktop/hangman/words.txt"));
		
		//new list to put all words from file into 
		List<String> words = new ArrayList<String>();
		
		
		while (scanner.hasNext()){
			words.add(scanner.nextLine());   //adding all words to the list words
		}
		
		Random rand = new Random();
		word = words.get(rand.nextInt(words.size()));   //picks a random word with upper bound as the size of the list words
			
		}
		
		else {
			System.out.println("Player 1, please enter your word:");
			word = keyboardInput.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Ready for PLlayer 2....");
			
		}
		
		//System.out.println(word);
		
		List<Character> playerGuesses = new ArrayList<Character>(); //make a list of each players guess
		
		int wrongCount=0;
		while (true){
			printHangedMan(wrongCount);
			if (wrongCount>=6){
				System.out.println("You Lose!!!!");
				System.out.println("The word was " + word);
				break;
			}
			printWordState(word, playerGuesses);
			
			if (!getPlayerGuess(keyboardInput,word, playerGuesses)){
				wrongCount++;
			}
			
			if (printWordState(word, playerGuesses)){
				System.out.println("You win!");
				break;		//if the number of words is = word list lentgh then game over, win!!!!
			}
			
			
			System.out.println("Please enter your guess for the word:");		//lets player guess the word
			if (keyboardInput.nextLine().equals(word)){
				System.out.println("You win!");
				break;
			}
			else{
				System.out.println("Nope try again");
			}
		}
	}
	
	private static boolean printWordState(String word,List<Character>playerGuesses){
		
		int correctCount = 0;	//counter for number of correct letterers
		
		for (int i = 0; i<word.length();i++){
				if (playerGuesses.contains(word.charAt(i))){		//check if player guess is right
					System.out.print(word.charAt(i));
					correctCount++;
				}
				else {
					System.out.print("-");
				}
			}
		System.out.println(); //to get to next line for "please enter..."
		
		return(word.length() == correctCount);		//returns true if correct count is the lentgh of the word list
	}

	private static boolean getPlayerGuess(Scanner keyboardInput, String word, List<Character>playerGuesses){
		
		System.out.println("Please enter a letter:");		
		String letterGuess = keyboardInput.nextLine();
		playerGuesses.add(letterGuess.charAt(0));
		
		return word.contains(letterGuess);
	}
	
	private static void printHangedMan(Integer wrongCount){
		System.out.println("  -------");
		System.out.println(" |       |");
		if (wrongCount>=1){
			System.out.println(" 0");
			}
		if (wrongCount>=2){
			System.out.print("\\ ");
			if (wrongCount>=3){
				System.out.println("/");
				}
			else {
			System.out.println("");
				}
			}
		if (wrongCount>=4){
			System.out.println(" |");				
			}
		if (wrongCount>=5){
			System.out.print("/ ");
			if (wrongCount>=6){
				System.out.println("\\");
				}
			else {
			System.out.println("");
				}
			}
		
	}
	
}