package Level2;

public class TargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetNumber t=new TargetNumber();
		System.out.println(t.solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
	public static int answer=0;
	 public int solution(int[] numbers, int target) {
	      
	        int[]sign=new int[numbers.length];
	        dfs(numbers,target,0,sign,numbers.length);
	        return answer;
	    }
	 public void dfs(int[] numbers,int target,int idx,int []sign,int length) {
		 if(idx==length) {
			 int sum=0;
			 for(int i=0;i<numbers.length;i++) {
				 if(sign[i]==0) {
					 //System.out.print(numbers[i]+" ");
					 sum+=numbers[i];
				 }
				 else {
					// System.out.print(-numbers[i]+" ");
					 sum-=numbers[i];
				 }
			 }
		
			 if (sum==target) answer++;
			 return;
		 }
		
		 sign[idx]=0;
		 dfs(numbers,target,idx+1,sign, length);
		
		 sign[idx]=1;
		 dfs(numbers,target,idx+1,sign,length);
	 }
}
