package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringAtMyWill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str1={"sun", "bed", "car"};
		String []str2= {"abce", "abcd", "cdx"};
		solution(str1, 1);
		solution(str2, 2);
	}
	public static String[] solution(String[] strings, int n) {
	      //String[] answer = new String [strings.length];
	      String []idxStr=new String[strings.length];
	      Map<String, Integer> newStr=new HashMap<String, Integer>();
	      int idx=0;
	      for(int i=0;i<strings.length;i++) {
	    	  idxStr[i]=String.valueOf(strings[i].charAt(n));
	      }
	      Arrays.sort(idxStr);
	      for(int i=0;i<strings.length;i++) {
	    	  for(int j=0;j<strings.length;j++) {
	    		  if(!strings[j].equals("")&&idxStr[i].equals(String.valueOf(strings[j].charAt(n)))) {
	    			  if(i>0&&!idxStr[i].equals(idxStr[i-1])) idx++;
	    				  
	    			  
	    			  newStr.put(strings[j], idx);
	    			  strings[j]="";
	    			  break;
	    		  }
	    		 
	    	  }
	      }
	 
	      List<Map.Entry<String, Integer>> list=new LinkedList<>(newStr.entrySet());
	      Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	            @Override
	            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	                int comparision = (o1.getValue() - o2.getValue()) ;
	               
	                return comparision == 0 ? o1.getKey().compareTo(o2 .getKey()) : comparision;
	            }
	        });

	
	      String []answer=new String[strings.length];
	      int i=0;
	        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
	            Map.Entry<String, Integer> entry = iter.next();
	            answer[i]=entry.getKey();
	            i++;
	        }
	      
	      return answer;
	  }
}
