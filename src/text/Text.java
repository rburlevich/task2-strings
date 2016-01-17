package text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	
	private String text; // TEXT

	public Text(String text) {
		this.text = text;
		Sentence sent = new Sentence(text);
		Word word = new Word(listOfSentences);
	}

	public ArrayList<String> listOfSentences = Sentence.listOfSentences;
	public ArrayList<String> listOfWords1 = Word.listOfWords1;


	public void printText(){ // Print text
		System.out.println("---Text---");
		System.out.println(text+"\n");
	}
	
	public String getText(){  // Return text
		return text;
	}

	public void printSentences(){ // This method prints all sentences
		System.out.println("---List of Sentences---");
		for (String sent : listOfSentences){
			System.out.println(sent);
		}
		System.out.println();
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
	 */

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

	public void test1(){
		ArrayList<String> newListOfSent = new ArrayList();
		for (String str : listOfSentences){
			if (str.charAt(str.length()-1)!='?'){ // If sentense doen't ends with '?' - add this sentense to the newListOfSent
				newListOfSent.add(str);           // eslse need modify this sentense
			} else {
				ArrayList<String> listOfWords = Word.cutWords(str);          // Cutting of words
				ArrayList<StringBuffer> listOfStrBufWords = new ArrayList(); // List of stringBuffer words
				for (String strWord : listOfWords){
					StringBuffer strBufWord= new StringBuffer(strWord.subSequence(0, strWord.length())); // Creating of stringBuffer word from string
					for (int i=1; i<=strBufWord.length()-1; i++){   // Deleting of letters from word
						if (strBufWord.charAt(i)==strBufWord.charAt(0)){
							strBufWord.deleteCharAt(i);
							i=i-1;
						}
					}
					listOfStrBufWords.add(strBufWord); // Adding of word to list of stringBuffer words
				}
				StringBuffer string = new StringBuffer(""); // Creating of empty stringBuffer
				for (StringBuffer strt4 : listOfStrBufWords){  // Creating of sentense from words
					string.append(strt4 + " ");
				}
				string.deleteCharAt(string.length()-3); // Cut space before '?'
				newListOfSent.add(string.toString().trim()); // Create string from stringBuffer

			}
		}
		//String text="";
		//for (String sentense : newListOfSent){
		//	text = text + sentense + " ";
		//}
		//return text.trim();
		listOfSentences = newListOfSent;
	}

	public String findWords(){
		String finalString = "";
		ArrayList<String> listOfwordsSent1 = new ArrayList<String>();
		ArrayList<String> listOfwordsAnotherSent = new ArrayList<String>();
		ArrayList<String> listOfReapeatedWords = new ArrayList<String>();
		Pattern p = Pattern.compile("[A-Za-z]+");
		Matcher m1 = p.matcher(listOfSentences.get(0));
		while (m1.find()){
			listOfwordsSent1.add(m1.group());
			System.out.println(m1.group());
		}
		for (int i=1; i<=listOfSentences.size()-1; i++){
			Matcher m2 = p.matcher(listOfSentences.get(i));
			while (m2.find()) {
				listOfwordsAnotherSent.add(m2.group());
			}
		}
		for (String word : listOfwordsSent1){
			for (String word2 : listOfwordsAnotherSent){
				if(word.toLowerCase().equals(word2.toLowerCase())){
					listOfReapeatedWords.add(word2);
				}
			}
		}
		for (int x=0;x<=listOfReapeatedWords.size()-1;x++){
			for (int y=1;y<=listOfReapeatedWords.size()-1;y++){
				if(x!=y & listOfReapeatedWords.get(x).equals(listOfReapeatedWords.get(y))){
					listOfReapeatedWords.remove(y);
				}
			}
		}
		for (String word : listOfReapeatedWords){
			finalString = finalString + word + " ";
		}
		return finalString;
	}

}
