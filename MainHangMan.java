/**
 * Name: Tochi Iroakazi
 * SUbject: ICS4U
 * description: A game of HAngMan using OOP
 */

import java.util.*;

public class MainHangMan {
	
	public static void main(String[] args) {
		HangMan letter = new HangMan ();
		
		letter.push();
		letter.randletter();
		
		String alpha = letter.text;
		
		System.out.println("Guess the corect " + alpha.length() + " letter word");
		System.out.println("Use Upper Case ");
		Game(letter);
	}
	public static void Game (HangMan myletter) {
		//stop the program when all the words have been found 
		if (myletter.WordPiece.contains("*") && myletter.Body.size() > 0) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("The junk "  + myletter.Junk);
			System.out.println("The Words "  + myletter.WordPiece);
			//check if the input is a character and if it has any of the alphabets in the ArrayList
			String input = scanner.next();
			if (input.matches("[A-Za-z]{1}")) {
				//if the Junk arraylist contain the input alphabet
				if (myletter.Junk.contains(input)) {
					myletter.ValidLetter(input);
					Game(myletter);
				}else {
					System.out.println("Invalid Choice, make sure you are using UPPER CASE and make sure the letter is an option ");
					Game(myletter);
					
				}
			}else {
				System.out.println("Type in a valid alphabet from the list above ");
				Game(myletter);
			}
		}else {
			System.out.println("The Word is " + myletter.text);
			if (!myletter.WordPiece.contains("*")) {
				System.out.println("DONE, YOU WON!");
				
			}else {
				System.out.println("DONE, YOU LOST! from main");
			}
		}
	
	}

}
