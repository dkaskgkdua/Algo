package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
		System.out.println(solution(new int[] {1,1,9,1,1,1}, 0));
		
	}
	  public static int solution(int[] priorities, int location) {
	        int answer = 1;
	        //1. 뒤에 큰 개수 / 2. 큰 숫자 / 3. 인덱스
	        //hm - 인덱스 , 뒤에 큰 개수
	        Map<Integer, Integer> hm=new HashMap<Integer, Integer>();
	        for(int i=0;i<priorities.length;i++) {  
	        	int cnt=0;
	        	for(int j=i+1;j<priorities.length;j++) {
	        		if(priorities[i]<priorities[j]) cnt++;
	        	}
	        	hm.put(i, cnt);
	        }
	        //hm.forEach((k,v)->System.out.println("인덱스 : "+k+" 뒤 : "+v));

		      List<Map.Entry<Integer, Integer>> list=new LinkedList<>(hm.entrySet());
		      Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
		            @Override
		            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		                int comparision = (o1.getValue() - o2.getValue()) ;
		               
		                return comparision == 0 ? o1.getKey().compareTo(o2 .getKey()) : comparision;
		            }
		        });
		      int i=0;
		    
		      for(Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
		            Map.Entry<Integer, Integer> entry = iter.next();
		           // System.out.print(entry.getKey());   System.out.print(entry.getValue());System.out.println();
		           if(entry.getKey()==location) return answer;
		            else answer++;
		        }
			return answer;
	      
	    }

}
