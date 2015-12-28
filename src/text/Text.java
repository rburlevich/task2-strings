package text;




public class Text {
	
	private String text;
	Sentence sent;
	Word wor;
	
	public Text(String text) {
		this.text = text;
		getText(this.text);
		sent = new Sentence(text);
		cutSent();
		wor = new Word(sent.listOfSentences);
		cutWord();
	}
	
	private void getText(String str){
		System.out.println("---Text---");
		System.out.println(str);
	}
	
	private void cutSent(){
		System.out.println("\n---Sentences---");
		sent.cutSentences();
	}
	
	private void cutWord(){
		System.out.println("\n---Words---");
		wor.cutWords();
	}
	

}
