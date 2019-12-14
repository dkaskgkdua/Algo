package level1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NoCompletePlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method st
		String []p1= {"leo","kiki", "eden"};
		String []c1= {"kiki", "eden"};
		
		String []p2= {"mislav", "stanko", "mislav", "ana"};
		String []c2= {"stanko", "ana", "mislav"};

		String []p3= {"marina", "josipa", "nikola", "vinko", "filipa"};
		String []c3= {"josipa", "filipa", "marina", "nikola"};
		
	    String[] p = { "keonho", "wooju", "minyoop", "kangil", "keonho", "keonho" }; // 마라톤 참여 선수들의 명단
        String[] c = { "keonho", "minyoop", "kangil", "keonho", "keonho" }; // 마라톤 완주 선수들의 명단
        
		System.out.println(solution(p1,c1));
		System.out.println(solution(p2,c2));
		System.out.println(solution(p3,c3));
		System.out.println(solution(p,c));
		
	}
	/*
	 * public static String solution(String[] participant, String[] completion) {
	 * String answer = ""; 
	 * Arrays.sort(participant);
	 *  Arrays.sort(completion); 
	 *  String  participant1="";
	 *   for(String str:participant) { participant1+=str+" "; }
	 * for(String str:completion) { participant1=participant1.replaceFirst(str, "");
	 * System.out.println("p : "+participant1); }
	 * answer=participant1.replaceAll(" ", ""); return answer; }
	 */
	 public static String solution(String[] participant, String[] completion) {
		 String answer = "";
		 Arrays.sort(participant); 
		 Arrays.sort(completion);
	
		for(int i=0;i<completion.length;i++) {
			if(!participant[i].equals(completion[i])) {
				answer=participant[i];
				break;
			}
			if(i==completion.length-1) {
				answer=participant[i+1];
			}
		}
		
		  return answer;
		  }
}
