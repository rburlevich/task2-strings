package text;




public class Text {
	
	private String text;
	Sentence sent;
	Word wor;
	
	public Text(String text) {
		this.text = text;
		getText(this.text);
		sent = new Sentence(text);
		wor = new Word(sent.listOfSentences);
		int i = 10;
		if (wor.numberOfLetters(i)!=-1){
			System.out.println(wor.numberOfLetters(i));
		} else System.out.println("Enter another number, please.");
		
		System.out.println(sent.findOfWord("you", 1));
		
	}
	
	private void getText(String str){
		System.out.println("---Text---");
		System.out.println(str);
	}
	
	private void cutSent(){
		System.out.println("\n---Sentences---");

	}
	
	private void cutWord(){
		System.out.println("\n---Words---");

	}
	

}
