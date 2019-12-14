package level1;

public class SquareRoot {

	public static void main(String[] args) {
		
		System.out.println(solution(3));
		System.out.println(solution(121));
	}
	  public static long solution(long n) {
	      long answer = 0;
	      
	     return String.valueOf(Math.sqrt(n)).matches("[0-9]+(.[0-9])")? (long) Math.pow(Math.sqrt(n)+1, 2):-1;
	     
	  }
}
