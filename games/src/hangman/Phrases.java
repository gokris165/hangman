package hangman;
import java.util.*;

public class Phrases 
{
	private String word;
	
	
	public Phrases() 
	{
		word = getWords();
	}
	
	
	// Choose a word at random from the list of words.
	public static String getWords()
	{
		String[] words = {"League of legends", "Basketball is fun", "People are cool", "Ultimate Frisbee is fun",
						"Early bird gets the worm", "Slow and steady wins", "Tom and Jerry", "Star wars", 
						"Wash your hands", "Social distancing", "Dont hoard supplies", "Stay at home",
						"Badminton", "Computers", "Tomato", "Fried Potatoes", "Go to bed early", "Take Care",
						"Iron man", "The avengers", "Parasyte", "Club Penguin", "Video games are fun",
						"Be nice to others", "Work hard play hard", "Listen to good music", "Do your homework"};		
		return words[(int)(Math.random() * 27)].toUpperCase();
	}
	
	
	// getter method
	public String getWord()
	{
		return word;
	}
	
	
	// check if the user selected letter is in the word.
	public boolean checkForMatch(String s)
	{
		if(word.contains(s.toUpperCase()))
		{
			return true;
		}
		return false;
	}
	
	
	// find all occurrences of the letter
	public ArrayList<Integer> findIndexOf(String s)
	{
		ArrayList<Integer> indexes = new ArrayList<>();
		String[] arr = word.split("");
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].equals(s.toUpperCase()))
				indexes.add(i);
		}
		return indexes;		
	}
}
