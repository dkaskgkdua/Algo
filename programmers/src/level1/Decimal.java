package level1;

public class Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(10));
		System.out.println(solution(5));
	}
	public static int solution(int n) {
	      int answer = 1;
	      int cnt=0;
	      for(int i=2;i<=n;i++) {
	    	 cnt=0;
	    	  for(int j=2;j<i;j++) {
	    		  if(i%j==0) break;
	    		  else cnt++;
	    		  
	    		  if(cnt==(i-2)) answer++;
	    	  }
	      }
	      return answer;
	  }
}
