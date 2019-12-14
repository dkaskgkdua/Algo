package level1;

public class Room {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6,12,10));
		System.out.println(solution(30,50,72));
	}
	public static String solution(int x, int y, int num) {
		  String answer = "";
	   int [][]room=new int[x][y];
	   int j=0,i=y-1;
	   for(j=0;j<=x-1;j++) {
		   for(i=y-1;i>0;i--) {
			   num--;
		   }
		   if(num<0) break;
	   }
	     answer=(i+1)+""+(y-j);
	     
	      return answer;
	}
}
