package text;

public class MainClass {
	public static void main(String args[]){
		String someText = "Let me say this: being a idiot is no box of chocolates. It questqqqion sentence? People laugh, lose patience, treat this this this this you is no box of shabby. Text?  Now they says folks sposed to be kind to the afflicted, but let me tell you—it ain’t always that way. Even so, I got no complaints, cause I reckon I done live a pretty interestin life, so to speak.";
		
		Text text = new Text(someText); // Creating of text
		text.printText(); // Displaying of text
		text.printSentences();
		text.test1();
		text.printSentences();
        System.out.println("REPEATED WORDS --->"+text.findWords());

	}

}
