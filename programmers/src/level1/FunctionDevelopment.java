package level1;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int [] {93,30,55},new int [] {1,30,5}));
		System.out.println(solution(new int [] {100,100,100},new int [] {1,30,5}));
		System.out.println(solution(new int [] {15, 1, 14, 9, 29, 25, 17, 24, 4, 27, 7, 19, 29, 14, 23, 4, 21, 3, 8, 14},new int [] {9, 11, 21, 16, 11, 21, 7, 5, 6, 30, 11, 24, 26, 18, 20, 18, 15, 30, 7, 18}));
	}

	 public static int[] solution(int[] progresses, int[] speeds) {
	        
	        List<Integer> answer=new ArrayList<Integer>();
	        List<Integer> distributeList=new ArrayList<Integer>();
	        for(int i=0;i<progresses.length;i++) {
	        	if((100-progresses[i])%speeds[i]!=0) distributeList.add((100-progresses[i])/speeds[i]+1);
	        	else distributeList.add((100-progresses[i])/speeds[i]);
	        }
	        System.out.println("½Ã°£"+distributeList);
	        for(int i=0;i<progresses.length;) {
	        	int cnt=1;
	        	for(int j=i;j<progresses.length;j++) {
	        		if(j==progresses.length-1) {
	        			i=progresses.length;
	        			answer.add(cnt);
	        			break;
	        		}
	        
	        		if(distributeList.get(i)>=distributeList.get(j+1)) cnt++;
	        		else {
	        			i=j+1;
	        			answer.add(cnt);
	        			break;
	        		}
	        	}
	        }
	       System.out.println("´ä:"+answer);
	        return answer.stream().mapToInt(i -> i).toArray();
	    }
}
