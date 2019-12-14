package level1;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(118372));
	}
	  public static long solution(long n) {
		  Integer []answer=new Integer[String.valueOf(n).length()];
		  int i=0;
		  while(n!=0) {
			  answer[i]=(int) (n%10);
			  n/=10;
			  i++;
		  }
		  Arrays.sort(answer,Collections.reverseOrder());
		long result=0;
		for(Integer k:answer) result=result*10+k;
	     return result;
	  }
}
