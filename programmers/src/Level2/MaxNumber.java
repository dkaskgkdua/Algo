package Level2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxNumber m=new MaxNumber();
		//System.out.println("start");
		System.out.println(m.solution(new int[] {6, 10, 2}));
		//System.out.println(m.solution(new int[] {0,0,0,0}));
		//System.out.println(m.solution(new int[] {6, 90, 2,6}));
		//System.out.println(m.solution(new int[] {100,99,0,777,6,89,33,782,5,1,0,99}));
	}
	public static String answer="-1";
	   public String solution(int[] numbers) {
	       
	        LinkedList<Long> numList=new LinkedList<Long>();
	        boolean []check=new boolean[numbers.length];
	        Arrays.fill(check,false);
	        Combi(numbers.length, numList, check, numbers);
	        return answer;
	    }
	   public static void Combi(int dep,LinkedList<Long> numList,boolean []check,int[]numbers) {
		   if(numList.size()==dep) {
			  String str="";
			   for(long i:numList) {
				   str+=i;
				   BigInteger reallyBig = new BigInteger(str);
				   BigInteger reallyBig1 =new BigInteger(answer);
				   if(reallyBig.compareTo(reallyBig1) == 1) answer=str;
			   }
			   if(answer.charAt(0)==0) answer="0";
			   return;
		   }
		   for(int i=0;i<check.length;i++) {
			   if(check[i]==false) {
				   numList.add((long)numbers[i]);
				   check[i]=true;
				   Combi(dep, numList, check, numbers);
				   check[i]=false;
				   numList.removeLast();
			   }
		   }
	   }

}
