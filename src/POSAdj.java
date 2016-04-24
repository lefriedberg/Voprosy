

public class POSAdj extends Grammar {
	private Word WORD;

	public POSAdj(Word a){
		super(a);
	}
	
	//StringBuilder
	private boolean hstem = true; //true if hard
	public static String newline = System.getProperty("line.separator");

	
	public void setSign(boolean a){
		hstem = a;
	}
	
	public String display(String word){
		if(hstem)
			return word + newline +
				"           m         f         n"  + newline +
				"nom       -ый       -ая       -ое"+ newline +
				"gen       -ого      -ой       -ого" + newline +
				"dat       -ому      -ой       -ому" + newline +
				"acc       -ого      -ую       -ое" + newline +
				"ins       -ым       -ой       -ым" + newline +
				"prep      -ом       -ой       -ом";
				
				
		else
			return word + newline +
					"           m         f         n"  + newline +
					"nom       -ий       -яя       -ее"+ newline +
					"gen       -его      -ей       -его" + newline +
					"dat       -ему      -ей       -ему" + newline +
					"acc       -его      -юю       -ее" + newline +
					"ins       -им       -ей       -им" + newline +
					"prep      -ем       -ей       -им";
			
	}
}


//WRITE DISPLAY METHODS