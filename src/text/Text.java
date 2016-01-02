package text;

public class Text {
	
	private String text; // TEXT
	
	
	public Text(String text) {
		this.text = text;
	
	}
	
	public void printText(){ // Print text
		System.out.println("---Text---");
		System.out.println(text+"\n");
	}
	
	public String getText(){  // Return text
		return text;
	}
	
	

}
