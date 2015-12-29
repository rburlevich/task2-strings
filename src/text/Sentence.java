package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
	String text;
	Sentence(String text){
		this.text = text;
		cutSentences();
	}
	public ArrayList<String> listOfSentences = new ArrayList<>();
	public void cutSentences(){
		Pattern p = Pattern.compile("[A-Z][a-z]+[ |A-Za-z|\\-|—|,|A-Za-z+:|A-Za-z+;|A-Za-z+’a-z+]*[\\.|\\?|!]");
		Matcher m = p.matcher(text);
		while (m.find()){
			listOfSentences.add(m.group());
			//System.out.println(m.group());
		}	
		for (String sent : listOfSentences){
			System.out.println(sent);
		}
			
		
	}
	
	public boolean findOfWord(String word, int i){
		if(listOfSentences.size()>=i){
			ArrayList<String> listOfWords = new ArrayList<>();
			Pattern p = Pattern.compile("[\\.|,|:|-|—]|[A-Za-z+’a-z+]+|[A-Za-z]+");
			Matcher m = p.matcher(listOfSentences.get(i));
			while (m.find()){
				listOfWords.add(m.group());
			}
			for (String str : listOfWords){
				if(str.equals(word)){
					return true;
				} 
			}
		}
		return false;
	}
}
