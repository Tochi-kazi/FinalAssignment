import java.util.*;

public class HangMan {
	ArrayList<String> Words = new ArrayList<String> ();
	ArrayList<String> Junk = new ArrayList<String> ();
	ArrayList<String> Body = new ArrayList<String> ();
	ArrayList<String> WordPiece = new ArrayList<String> ();
	
	Scanner scanner = new Scanner(System.in);	 
	
	Random r = new Random();
	String word = "";
	String text = "" ;
	
	//generate random characters plus the real characters.
	protected void randletter() {
		//char c; //from 65 to 90
		for ( char c = 'A'; c <= 'Z'; c++) {
	        //System.out.print(c);
	        Junk.add(Character.toString(c));
	    }
		
	}
	//put in words into the array 
	public void push() {
		//add words in the word bracket
		Words.add("AWKWARD");
		Words.add("BAGPIPES");
		Words.add("BANJO");
		Words.add("BUNGLER");
		Words.add("COMPUTER");
		Words.add("CRYPT");
		Words.add("DWARVES");
		Words.add("FERVID");
		Words.add("FISHHOOK");
		Words.add("BOOKS"); 
		Collections.shuffle(Words);
		//add an extericks for the blanks
		text = Words.get(0);
		
		for (int i = 0; i < text.length(); i++) {
			WordPiece.add("*");
		} 
		
		//add body Parts
		Body.add("Head");
		Body.add("Chest");
		Body.add("left Hand");
		Body.add("right Hand");
		Body.add("left Leg");
		Body.add("right Leg");
		return;
		
	}

	//check if the letter is correct and give a new list of letter if correct.
	public void ValidLetter(String l) {
		if (Junk.contains(l)) {
			//check for the input inside the junk and remove
			for (int j = 0; j < Junk.size(); j++) {
				if (Junk.get(j).equals(l)){
					Junk.remove(j);
					//check if the word contains the letter.
					if (text.contains(l)) {
						for (int i = 0; i < text.length(); i++) {
							//check if letter equals any letter in the input and print out the remaining
							if (l.equals(Character.toString(text.charAt(i)))){
								WordPiece.set(i, l);
							}
							
					
						}
					//else call the lose function
					}else {
						lose();
					}
				}
			}
			
		}	
		
	}
	//remove a body parts after each wrong alphabet
	public void lose () {
		System.out.println("Wrong Guess you lost " + Body.remove(0));
		System.out.println("You have " + Body.size() + " more body parts remaining");
		if (Body.size() == 0) {
			System.out.println("You have lost the game ");
			scanner.close();
		}
	
	}

}
