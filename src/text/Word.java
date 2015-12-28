package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
	ArrayList<String> sentences = new ArrayList<>();
	Word(ArrayList<String> sentences){
		this.sentences = sentences;
	}
	ArrayList<String> listOfWords = new ArrayList<>();
	public void cutWords(){
		for (String sent : sentences){
			Pattern p = Pattern.compile("[[A-Za-z]+|\\.|\\?|:|,|!|-]");
			Matcher m = p.matcher(sent);
			while (m.find()){
				listOfWords.add(m.group());
			}
			
		}
		
		for (String str : listOfWords){
			System.out.println(str);
		}
		
	}

}
