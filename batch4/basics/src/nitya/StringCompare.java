package nitya;

public class StringCompare {
	
	String s1="clemsonuniv";
	String s2="clemson";
	
	public void  compare(String s1, String s2){
		for(int i=0;i<s1.length();i++){
			
			char c1= s1.charAt(i);
			char c2= s2.charAt(i);
			
			if(c1==c2)
				System.out.println("Match found");
			else
				System.out.println("Match not found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//TODO i need to complete StringCompare assignment.
	}

}
