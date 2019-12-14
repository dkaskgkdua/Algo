package level1;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumberInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i:solution(12340)) System.out.println(i);;
	}
	  public static int[] solution(long n) {
	      List<Integer> answer=new ArrayList<Integer>();
	     
	      while(!String.valueOf(n).equals("0")) {
	    	  answer.add((int) (n%10));
	    	  n=n/10;
	      }
	      return answer.stream().mapToInt(i->i).toArray();
	  }
}
