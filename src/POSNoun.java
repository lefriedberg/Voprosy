

public class POSNoun extends Grammar {
	private boolean hstem = true; //true if hard
	private boolean masc = true; //true if masc, false fem, 
	public static String newline = System.getProperty("line.separator");
	private Word WORD;

	public POSNoun(Word a){
		super(a);
	}
	
	public void setSign(boolean a){
		hstem = a;
	}
	
	public void setGender(boolean a){
		masc = a;
	}
	
	public String display(String word){
		if(hstem && masc){
			word = word + newline +
					"nom: --" + newline +
					"gen: -a" + newline +
					"dat: -у" + newline +
					"acc: -a / --" + newline +
					"ins: -ом" + newline +
					"prep: -е"
					;
		}else if(hstem && !masc){
			word = word + newline +
					"nom: --" + newline +
					"gen: -я" + newline +
					"dat: -ю" + newline +
					"acc: -я / --" + newline +
					"ins: -ем" + newline +
					"prep: -е"
					;
		}else if(!(hstem || masc)){
			word = word + newline +
					"nom: -я" + newline +
					"gen: -и" + newline +
					"dat: -е" + newline +
					"acc: -ю / --" + newline +
					"ins: -ей" + newline +
					"prep: -е"
					;
		}else{
			word = word + newline +
					"nom: -а" + newline +
					"gen: -ы" + newline +
					"dat: -е" + newline +
					"acc: -у / --" + newline +
					"ins: -ой" + newline +
					"prep: -е"
					;
		}
		
		return word;
	}
}
