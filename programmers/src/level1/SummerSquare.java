package level1;

import org.omg.CORBA.REBIND;

public class SummerSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 12));
	}
	public static long solution(int w,int h) {
	
        long min=Math.min(w, h);
        long max=Math.max(w, h);
        long remain=1;
        while(remain>0) {
        	remain=max%min;
        	max=min;
        	min=remain;
        }
    	long answer = w*h-max*(w/max + h/max -1);
		return answer;
	}
}
