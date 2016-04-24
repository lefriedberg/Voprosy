

public class POSVerb extends Grammar{
	private String con = "";
	private boolean first = true;
	private boolean regular = true;
	public static String newline = System.getProperty("line.separator");
	private Word WORD;

	
	
	public POSVerb(Word a){
		super(a);
	}
	
	public void conjugate(boolean reg, boolean f){
		if (reg){
			regular = true;
			first = f;
		}else{
			regular = false;
		}
	}
	
	public void irco(String a, String b, String c){
		con = "Я  " + a + newline 
				+ "Ты  " + b + newline +
				"Они  " + c;
	}
	
	public String display(String word){
		if(!regular){
			word = word + newline + con;
		}else if(first){
			word = word + newline + 
					"я" + word.substring(0, word.length() - 3) + "аю"+ newline +
					"я" + word.substring(0, word.length() - 3) + "аешь"+ newline +
					"я" + word.substring(0, word.length() - 3) + "ают";
		}else{
			word = word + newline +
			"я" + word.substring(0, word.length() - 3) + "у"+ newline +
			"я" + word.substring(0, word.length() - 3) + "ишь"+ newline +
			"я" + word.substring(0, word.length() - 3) + "ят";
		}
		
		return word;
	}

}
