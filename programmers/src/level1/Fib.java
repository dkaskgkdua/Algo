package level1;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fib(70));
	}
	public static int data[]=new int[100];
	public static int Fib(int n) {
		//��������
		if(n<=1) {
			return 1;
		}
		if(data[n]!=0) {
			return data[n];
		}
		//ó��
		else {
			
			data[n ]=Fib(n-2)+Fib(n-1);
			return data[n];
		}
	}
	
}
