package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
	private ArrayList<String> sentences = new ArrayList<>();
	Word(ArrayList<String> sentences){
		this.sentences = sentences;
		cutWords();
	}
	
	ArrayList<String> listOfWords = new ArrayList<>(); // List of words
	
	/** 
	 * This method cut words from the sentences
	 * */
	public void cutWords(){              
		for (String sent : sentences){
			Pattern p = Pattern.compile("[\\.|,|:|-|—]|[A-Za-z+’a-z+]+|[A-Za-z]+");
			Matcher m = p.matcher(sent);
			while (m.find()){
				listOfWords.add(m.group());
			}
		}
		
	}
	
	public void printWords(){ // This method prints all words
		System.out.println("---List of Words---");
		int i = 0;
		for (String str : listOfWords){ 
			System.out.println((i++)+". "+str);
		}
		System.out.println();
	}
	
	/** 
	 * @param
	 * int - number of word in text
	 * 
	 * This method returns number of letters in the word
	 * */
	
	public void printNumberOfLetters(int i){
		if (numberOfLetters(i)!=-1){
			System.out.println(numberOfLetters(i));
		} else System.out.println("Enter another number, please.");
	}
	
	private int numberOfLetters(int numberOfWord){ 
		if(listOfWords.size()>=numberOfWord){
			String a = listOfWords.get(numberOfWord);
			return a.length();
		} else return -1;
	}
}
