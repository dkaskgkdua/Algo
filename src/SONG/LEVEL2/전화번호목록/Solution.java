package SONG.LEVEL2.전화번호목록;

import java.util.HashMap;
class Solution {
    public boolean solution(String[] phone_book) {
       HashMap<Integer, String> bookMap = new HashMap<Integer, String>();
    	    	for(int i =0; i < phone_book.length; i++) {
    	        	bookMap.put(i, phone_book[i]);
    	        }
    	    	for(int i =0; i< phone_book.length; i++) {
    	    		
    	    		for(int j=0; j < phone_book.length; j++) {
    	    			if(i==j) {continue;}
    	    			int n = bookMap.get(j).indexOf(phone_book[i]);
    	    			if(n == 0) {return false;}
    	    		}
    	    		
    	    	}
    	    	return true;
    }
}