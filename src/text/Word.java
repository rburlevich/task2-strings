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
	
	ArrayList<String> listOfWords1 = new ArrayList<>(); // List of words
	
	/** 
	 * This method cut words from the sentences
	 * */
	public static ArrayList<String> cutWords(String sentence){ 
		ArrayList<String> listOfWords = new ArrayList<>();
        Pattern p = Pattern.compile("[\\.|,|:|-|—]|[A-Za-z+’a-z+]+|[A-Za-z]+");
		Matcher m = p.matcher(sentence);
		while (m.find()){
			listOfWords.add(m.group());
		}
        return listOfWords;
	}
	
	public void printWords(){ // This method prints all words
		System.out.println("---List of Words---");
		int i = 0;
		for (String str : listOfWords1){ 
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
		if(listOfWords1.size()>=numberOfWord){
			String a = listOfWords1.get(numberOfWord);
			return a.length();
		} else return -1;
	}
}
