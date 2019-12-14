package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GymClothes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int [] lost1= {2,4}; int []reserve1= {1,3,5};
		  System.out.println("test1 : "+solution(5, lost1,new int[] {1,3,5} ));
		  
		  int [] lost2= {2,4}; int []reserve2= {3};
		  System.out.println("test2 : "+solution(5, lost2,reserve2));
		  
		
		int[] lost3 = { 2, 3, 4 };
		int[] reserve3 = { 3, 4, 5 };
		System.out.println("test3 : " + solution(5, lost3, reserve3));
		
		int[] lost4 = { 2, 3, 4 };
		int[] reserve4 = {1,2,3,6 };
		System.out.println("test4 : " + solution(7, lost4, reserve4));
		
		int[] lost5 = { 3 };
		int[] reserve5 = {1 };
		System.out.println("test4 : " + solution(3, lost4, reserve4));

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		Arrays.sort(lost);
		Arrays.sort(reserve);

		List<Integer> lost1 = Arrays.stream(lost).boxed().collect(Collectors.toList());
		List<Integer> reserve1 = Arrays.stream(reserve).boxed().collect(Collectors.toList());

		for (int i = 0; i < lost1.size();) {
			int cnt = 0;
			for (int j = 0; j < reserve1.size(); j++) {
				if (lost1.get(i) == reserve1.get(j)) {
					lost1.remove(i);
					reserve1.remove(j);

					break;
				} else
					cnt++;

			}
			if (cnt == reserve1.size())
				i++;
		}
	    
        int k=0;
        for(int i:reserve1) {
        	for(int j=k;j<lost1.size();) {
        		if((i-1)==lost1.get(j) || (i+1)==lost1.get(j)) {
        			answer++;
        			k=++j;
        			
        			break;
        		}
        		j++;
        	}
        	
        }
        answer=answer+(n-lost1.size());
  
		return answer;
	}
}
