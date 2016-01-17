package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
	//private ArrayList<String> sentences = new ArrayList<>();
	Word(ArrayList<String> sentences){
		for (String sent : sentences){
			listOfWords1 = cutWords(sent);
		}
		
	}
	
	public static ArrayList<String> listOfWords1 = new ArrayList<>(); // List of words
	
	/** 
	 * This method cut words from the sentence
	 * */
	public static ArrayList<String> cutWords(String sentence){ 
		ArrayList<String> listOfWords = new ArrayList<>();
        Pattern p = Pattern.compile("[\\.|,|:|-|—|\\?]|[A-Za-z+’a-z+]+|[A-Za-z]+");
		Matcher m = p.matcher(sentence);
		while (m.find()){
			listOfWords.add(m.group());
		}
        return listOfWords;
	}
	
}
