package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
	String text;
	Sentence(String text){
		this.text = text;
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

}
