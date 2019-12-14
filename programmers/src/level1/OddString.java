package level1;

public class OddString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("  try hello world strys try  t "));
	}

	public static String solution(String s) {
		  String answer = "";
	      String []str=s.split(" ",-1);
	      for(String st:str) {
	    	  System.out.println("st : "+st);
	    	  for(int i=0;i<st.length();i++) {
	    		  if(i%2==0) answer+=st.substring(i, i+1).toUpperCase();
	    		  else  answer+=st.substring(i, i+1).toLowerCase();
	    			  
	    		  
	    	  }
	    	  answer+=" ";
	      }
       answer=answer.substring(0, s.length());
	      return answer;
	}

}
