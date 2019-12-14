package level1;

public class year2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5, 24));
	}
	  public static String solution(int a, int b) {
	      String answer = "";
	      String [] day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	      
	      int [] monthOneDay=new int[13];
	      monthOneDay[1]=5;
	      
	      for(int i=2;i<13;i++) {
	    	  if(i==3) monthOneDay[i]=(monthOneDay[i-1]+1)%7;
	    	  else if((i%2==0 && i<9)|| i==9) monthOneDay[i]=(monthOneDay[i-1]+3)%7;
	    	  else if(i%2==1 && i<9) monthOneDay[i]=(monthOneDay[i-1]+2)%7;
	    	  else if(i>9 && i%2==0 )monthOneDay[i]=(monthOneDay[i-1]+2)%7;
	    	  else if(i>9 && i%2==1) monthOneDay[i]=(monthOneDay[i-1]+3)%7;
	      }
	      
	      answer=day[(b-1+monthOneDay[a])%7];
	      return answer;
	  }
}
