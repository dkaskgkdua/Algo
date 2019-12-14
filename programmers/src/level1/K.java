package level1;

import java.util.ArrayList;
import java.util.Collections;

public class K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [ ] array= {1, 5, 2, 6, 3, 7, 4};
		int [][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		for(int i:solution(array, commands)) {
			System.out.println(i);
		}
	}
	  public static int[] solution(int[] array, int[][] commands) {
	     int [] answer= new int[commands.length];
	        int i=0;
	        ArrayList<Integer> list=new ArrayList<Integer>();
	     for(i=0;i<commands.length;i++) {
	    	 for(int j=commands[i][0]-1;j<=commands[i][1]-1;j++) {
	    		 list.add(array[j]);
	    	 }
	    	 Collections.sort(list);
	    	answer[i]=list.get(commands[i][2]-1);
	    	
	    	 list.clear();
	     }
	        return answer;
	    }
}
