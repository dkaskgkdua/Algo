package SONG.LEVEL2.위장;
import java.util.HashMap;
    	
    	class Solution {
    	    public int solution(String[][] clothes) {
    	        HashMap<String, Integer> map = new HashMap<String, Integer>();
    			 
    	        for (String [] clothe : clothes) {
    	            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
    	        }
    			int answer = 1;

    	        for (int value : map.values()) {
    	            answer *= (value + 1);
    	        }
    	        answer -=1;
    	        return answer;
    	    }
    	}