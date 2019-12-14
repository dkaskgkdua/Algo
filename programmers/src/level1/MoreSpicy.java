package level1;

import java.util.Arrays;

public class MoreSpicy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(	solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
		}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        while(Arrays.stream(scoville).filter(x->x>=K).count()!=scoville.length) {
        	Arrays.sort(scoville);
        	int mixScoville=scoville[0]+scoville[1]*2;
        	scoville[0]=mixScoville;
        	scoville=Arrays.copyOfRange(scoville, 2,scoville.length ) ; 
        	answer++;
        	}
        return  answer;
       
    }
}
