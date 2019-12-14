package level1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Integer> result=new HashMap<Integer, Integer>();
		int [][] answerSheet=new int [][] {
			{1,2,3,4,5},
			{2,1,2,3,2,4,2,5},
			{3,3,1,1,2,2,4,4,5,5}
		};
		
		IntStream.range(1, 4).forEach(x->result.put(x,0));
		for(int i=0;i<4;i++) {
			System.out.println(result.get(i));
		}
	}

}
