package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {4,3,2,1};
		for(int i:solution(a)) System.out.println(i);
	}

	 public static int[] solution(int[] arr) {
		 int [] arr2=Arrays.copyOf(arr, arr.length);
		 Arrays.sort(arr2);
		int[]answer= {-1};
		return arr.length-Arrays.stream(arr).filter(x->x==10).count()==0 ? answer: Arrays.stream(arr).filter(x->x!=arr2[0]).toArray();

	 }
}
