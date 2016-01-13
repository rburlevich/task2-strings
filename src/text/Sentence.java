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
	
	public ArrayList<String> listOfSentences = new ArrayList<>(); // The list of sentences
	
	/** 
	 * This method cut sentences from the text
	 * */
	private void cutSentences(){
		Pattern p = Pattern.compile("[A-Z][a-z]+[ |A-Za-z|\\-|—|,|A-Za-z+:|A-Za-z+;|A-Za-z+’a-z+]*[\\.|\\?|!]");
		Matcher m = p.matcher(text);
		while (m.find()){
			listOfSentences.add(m.group());
		}	
    }
	
	public void printSentences(){ // This method prints all sentences 
		System.out.println("---List of Sentences---");
		for (String sent : listOfSentences){
			System.out.println(sent);
		}
		System.out.println();
	}
	
	/** 
	 * This method find a word in a sentence
	 * @param 
	 * 1. String - a word which need find
	 * 2. Number of sentence in which find word
	 * 
	 * */
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
	
	/** 
	 * This method change positions of words in the sentence
	 * */
	
	public String changeingPositionOfWords(int numberOfSentence, int numberOfWord1, int numberOfWord2){
		String str = "";
		if(listOfSentences.size()>=numberOfSentence){
			ArrayList<String> listOfWords = new ArrayList<>();
			listOfWords = Word.cutWords(listOfSentences.get(numberOfSentence));
			if (numberOfWord1<=listOfWords.size() && numberOfWord2<=listOfWords.size() ){
				String word1 = listOfWords.get(numberOfWord1);
				listOfWords.set(numberOfWord1, listOfWords.get(numberOfWord2));
				listOfWords.set(numberOfWord2, word1);
				for (String a : listOfWords){
					if (a.equals(".")|a.equals(",")|a.equals(";")|a.equals(":")|a.equals("!")|a.equals("?")){
						str = str + a;
					} else str = str + " " + a;
				}
			} else return "Word #"+numberOfWord1+" or #"+numberOfWord2+" is absent. Select another word, please!";
		} else return "Sentence #"+numberOfSentence+" is absent. Select another sentence, please!";
		return str.trim();
	} 
	
	/**
	 * This method deletes a substring from a string
	 * */
	
	public String deletetingOfSubstring(int numberOfSentence, char a, char b){
		String str = "";
		if(listOfSentences.size()>=numberOfSentence){
			if (listOfSentences.get(numberOfSentence).indexOf(a)!=-1 & listOfSentences.get(numberOfSentence).indexOf(b)!=-1){
				str = listOfSentences.get(numberOfSentence).replace(listOfSentences.get(numberOfSentence).substring(listOfSentences.get(numberOfSentence).indexOf(a), listOfSentences.get(numberOfSentence).lastIndexOf(b)), "");
			} else return "There's no such substring";
		} else return "There's no such sentence";
		return str;
	}

	public String test1(){
		ArrayList<String> strBuff = new ArrayList();
		for (String str : listOfSentences){
			if (str.charAt(str.length()-1)!='?'){
				strBuff.add(str);
				System.out.println("trase------no question------->"+str);
			} else {
				System.out.println("trase------question------->"+str);
				ArrayList<String> strBuff2 = Word.cutWords(str);
				for (String strt : strBuff2){
					ArrayList<StringBuffer> strBuff3 = new ArrayList();
					StringBuffer strt2= new StringBuffer(strt.subSequence(0, strt.length()));
					System.out.println("trase------word from question------->"+strt2);
					for (int i=1; i<=strt2.length()-1; i++){
						if (strt2.charAt(i)==strt2.charAt(0)){
							strt2.deleteCharAt(i);
							i=i-1;
						}
					}
					strBuff3.add(strt2);
					StringBuffer strt3 = new StringBuffer("");
					for (StringBuffer strt4 : strBuff3){
						strt3.append(strt4);
						System.out.println("trase------question-----------------sent------->"+strt3);
					}
					System.out.println("trase------question-----------------sent2------->"+strt3);
					strBuff.add(strt3.toString());
				}

			}
		}
		String st="";
		for (String ss : strBuff){
			st = st + ss + " ";
		}
		return st;
	}
}
