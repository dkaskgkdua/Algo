package level1;

public class RamenFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RamenFactory r=new RamenFactory();
		//System.out.println(r.solution(4, new int[] {4,10,15}, new int[] {20,5,10}, 30)); //2
		//System.out.println(r.solution(4, new int[] {1,2,3,4}, new int[] {10,40,30,20}, 100)); //4
		//System.out.println(r.solution(3, new int[] {1,2,3,4,5,6,7,8}, new int[] {1,1,1,1,2,1,1,50}, 50)); //5
		//System.out.println(r.solution(4, new int[] {1,2,3,4}, new int[] {50,40,20,10}, 100)); //3
		
	}
	public static int answer=Integer.MAX_VALUE;
	  public int solution(int stock, int[] dates, int[] supplies, int k) {
	      
	        boolean[] visited = new boolean[supplies.length];
	        powerSet(supplies, visited, supplies.length, 0,k);
	        return answer;
	    }
	  public void powerSet(int[] arr, boolean[] visited, int n, int idx,int k) {
		    if(idx == n) {
		    	answer=print(arr, visited, n,k);
		        return;
		    }
		 
		    visited[idx] = false;
		    powerSet(arr, visited, n, idx + 1,k);
		 
		    visited[idx] = true;
		    powerSet(arr, visited, n, idx + 1,k);
		}

	  public int print(int[] arr, boolean[] visited, int n,int k) {
		  int cnt=0,sum=0;
	        for(int i=0; i<n; i++) {
	            if(visited[i] == true) {
	            	cnt++;
	            	sum+=arr[i];
	               // System.out.print(arr[i] + " ");
	            }
	           
	            if(sum>=k) {
	            	
	            	answer=Math.min(answer, cnt);
	            }
	        }
	        return answer;
	    }
}
