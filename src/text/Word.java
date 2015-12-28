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
	ArrayList<String> listOfWords = new ArrayList<>();
	public void cutWords(){
		for (String sent : sentences){
			Pattern p = Pattern.compile("[\\.|,|:|-|—]|[A-Za-z+’a-z+]+|[A-Za-z]+");
			Matcher m = p.matcher(sent);
			while (m.find()){
				listOfWords.add(m.group());
			}
			
		}
		int i = 0;
		for (String str : listOfWords){
			System.out.println((i++)+". "+str);
		}
	
		
	}
	
	public int numberOfLetters(int numberOfWord){
		if(listOfWords.size()>=numberOfWord){
			String a = listOfWords.get(numberOfWord);
			return a.length();
		} else {
			System.out.println("Enter another number, please.");
			return -1;
		}
		
		
	}

}
