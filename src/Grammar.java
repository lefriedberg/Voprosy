


public class Grammar  {
	public static String newline = System.getProperty("line.separator");
	private Word WORD;
	
	public Word getWord(){
		return WORD;
	}
	
	public void setWord(Word w){
		WORD = w;
	}
	
	public Grammar(Word w){
		WORD = w;
	}
	
	public void setSign(boolean a){
		
	}

	public void setCase(int a){}
	
	public void conjugate(boolean reg, boolean f){}
	
	public void irco(String a, String b, String c){}
	
	public void setGender(boolean a){
	}
	
	public String display(String a){
		return a;
	}
	
}
