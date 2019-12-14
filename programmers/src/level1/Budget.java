package level1;

import java.util.Arrays;

public class Budget {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] d1= {1,3,2,5,4};
		int []d2= {2,2,3,3};
		System.out.println(solution(d1, 9));
		System.out.println(solution(d2, 10));
	}
	  public static int solution(int[] d, int budget) {
	     
	  int answer=0;
	 Arrays.sort(d);
	 for(int i=0;i<d.length;i++) {
		 int sum=0;
		 int cnt=0;
		 for(int j=i;j<d.length;j++) {
			 sum+=d[j];
			 cnt++;
			 if(sum<=budget) answer=Math.max(answer, cnt);
		 }
	if(answer>(d.length-i)) break;
	 }

	      return answer;
	  }

}
