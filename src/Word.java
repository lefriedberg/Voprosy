
public class Word implements Comparable<Word> {
	private String english;
	private String russian;
	
	public Word(String e, String r){
		english = e;
		russian = r;
	}
	
	public String E(){
		return english;
	}
	
	public String R(){
		return russian;
	}
	
	public void setE(String e){
		english = e;
	}
	
	public void setR(String r){
		russian = r;
	}

	public int compareTo(Word a) {
		System.out.println("COMPARETO");
		if(a == null)
			System.out.println("nullhere?");
		if (E() != null && a.E() != null)
			return E().compareTo(a.E());
		return 0;
	}


	
}
