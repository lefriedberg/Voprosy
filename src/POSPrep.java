

public class POSPrep extends Grammar{
	private int caseTaken = 0; //0 if nominative etc.
	private Word WORD;

	public POSPrep(Word a){
		super(a);
	}
	public void setCase(int a){
		caseTaken = a;
	}
	
	public String display(String word){
		switch(caseTaken){
			case 0: word = word + "Takes Nominative (Why??)!";
				break;
			case 1: word = word + "Takes Genitive!";
				break;
			case 2: word = word + "Takes Dative!";
				break;
			case 3: word = word + "Takes Accusative!";
				break;
			case 4: word = word + "Takes Instrumental!";
				break;
			case 5: word = word + "Takes Prepositional!";
				break;
		}
		
		return word;
	}
}
