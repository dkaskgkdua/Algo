// https://programmers.co.kr/learn/courses/30/lessons/43164

import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        int num = tickets.length;
        String[][] route = new String[num][2];
        boolean[] visited = new boolean[num];
        answer = new String[num + 1];
                
        permutation(tickets, route, visited, 0);
        
        return answer;
    }
    
    void permutation(String[][] list, String[][] output, boolean[] visited, int depth) {
        if ( depth == 1 && !output[0][0].equals("ICN")) {
            return;
        }
        
        if ( depth > 1 && !output[depth - 1][0].equals(output[depth - 2][1])) {
            return;
        }
        
		if ( depth == list.length ) {
            if ( checkFasterAlphabet(output) ) {
                answer[0] = output[0][0];
                for (int i = 0; i < output.length; i++) {
                    answer[i+1] = output[i][1];
                }
                return;
            }
        }
        
		for (int i = 0; i < list.length; i++) {
			if ( !visited[i] ) {
				visited[i] = true;
				output[depth] = list[i];
				permutation(list, output, visited, depth + 1);
				visited[i] = false;
			}
		}
        
	}
     
    boolean checkFasterAlphabet(String[][] tickets) {
        if ( answer[0] == null ) {
            return true;
        }
        
        for (int i = 0; i < tickets.length - 1; i++) {            
            if ( tickets[i][0].compareTo(answer[i]) > 0 ) {
                return false;
            }
            
            if ( tickets[i][0].compareTo(answer[i]) < 0 ) {
                return true;
            }
        }
        
        return false;
    }   
}