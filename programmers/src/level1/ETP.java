package level1;


public class ETP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= {1,2,3,4,5};
		int []b= {1,3,2,4,2};
		System.out.println(solution(a));
		System.out.println(solution(b));
		
	}
	  public static int[] solution(int[] answers) {
	        int []answer;
	        int []first= {1,2,3,4,5};
	        int [] second= {2,1,2,3,2,4,2,5};
	        int [] third= {3,3,1,1,2,2,4,4,5,5};
	        int []cnt=new int[3];
	       
	        int j=0;
	        for(int i=0;i<answers.length;i++) {
	        	if(answers[i]==first[j]) {
	        		
	        		cnt[0]++;
	        	}
	        	
	        	j++;
	        	if(i==first.length) j=0;
	        }
	        j=0;
	        for(int i=0;i<answers.length;i++) {
	        	if(answers[i]==second[j]) {
	        		
	        		cnt[1]++;
	        	}
	        	
	        	j++;
	        	if(i==second.length) j=0;
	        }
	        j=0;
	        for(int i=0;i<answers.length;i++) {
	        	if(answers[i]==third[j]) {
	        		
	        		cnt[2]++;
	        	}
	        	
	        	j++;
	        	if(i==third.length) j=0;
	        }

	       if(cnt[0]==cnt[1]&& cnt[1]==cnt[2]) {
	    	 answer=new int[3];
	    	   answer[0]=1;
	    	   answer[1]=2;
	    	   answer[2]=3;
	       }
	       else if(cnt[0]==cnt[1]&& cnt[1]!=cnt[2]) {
	    	   answer=new int[2];
	    	   answer[0]=1;
	    	   answer[1]=2;
	       }
	       else {
	    	   answer=new int[1];
	    	   int idx=Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
	    	   for(int i=0;i<3;i++) {
	    		   if(idx==cnt[i]) answer[0]=i+1;
	    	   }
	       }
	
	        return answer;
	    }
}
