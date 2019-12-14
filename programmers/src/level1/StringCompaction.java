package level1;

public class StringCompaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("abcabcdede"));
	}
	  public static int solution(String s) {
	        int answer = s.length();
	        int cnt=1;
	        //자를 개수
	       
	        for(int i=1;i<s.length()+1;i++) {
	        	String str="";
	        	 String same=s.substring(0, i);
	        	 //System.out.println(i);
	        	for(int j=i;j<s.length();j+=i) {
	        		//System.out.println("j : "+j);
	        		//System.out.println(":");
	        		//System.out.println((j+i>=s.length()-1) ? s.length()-1:j+i);
	        		if(same.equals(s.substring(j,(j+i>=s.length()-1) ? s.length():j+i))) {
	        			cnt++;
	        		}
	        		else {
	        			str+=(cnt!=1) ? String.valueOf(cnt)+same :same;
	        			cnt=1;
	        			same=(j+i>s.length()-1)? "":s.substring(j,j+i);
	        			//System.out.println("same : "+same);
	        		}
	        	}
	        	System.out.println(str);
	        	cnt=1;
	        	answer= (answer>str.length()) ? str.length():answer;
	        }
	        
	        return answer;
	    }
}
