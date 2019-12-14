package level1;

public class MiddleStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("qwer"));
	}
	 public static String solution(String s) {
	      String answer = "";
	      if(s.length()%2==0) {
	    	  answer=s.substring(s.length()/2-1, s.length()/2+1);
	      }
	      else {
	    	  answer=s.substring(s.length()/2, s.length()/2+1);
	      }
	      return answer;
	  }
}
/*
 * int num=s.length(); if(s.length()%2==0){
 * answer+=s.substring(num/2-1,num/2+1);
 * 
 * } else{ answer+=s.substring(num/2,num/2+1); }
 */