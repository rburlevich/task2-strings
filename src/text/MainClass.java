package text;

public class MainClass {
	public static void main(String args[]){
		String someText = "Let me say this: bein a idiot is no box of chocolates. People laugh, lose patience, treat you shabby. Now they says folks sposed to be kind to the afflicted, but let me tell you—it ain’t always that way. Even so, I got no complaints, cause I reckon I done live a pretty interestin life, so to speak.";
		
		Text text = new Text(someText); // Creating of text
		text.printText(); // Displaying of text
		
		Sentence sent = new Sentence(text.getText()); // Cutting of sentences
		sent.printSentences(); //Printing of sentences
		
		Word word = new Word(sent.listOfSentences); // Cutting of words
		word.printWords(); //Printing of words
		
		System.out.println(sent.findOfWord("you", 1));
		
		word.printNumberOfLetters(3); 
		
		System.out.println(sent.changeingPositionOfWords(0, 3, 5));
	
	}

}
