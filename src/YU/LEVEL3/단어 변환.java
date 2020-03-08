// https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.Arrays;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int minimum = words.length + 1;
        
        minimum = dfs(begin, target, words, new boolean[words.length], 0, words.length + 1, words.length);
        
        return minimum == words.length + 1? 0 : minimum;
    }
    
    int dfs(String word, String target, String[] words, boolean[] visited, int n, int minimum, int maximum) {
        for (int i = 0; i < maximum; i++) {
            if ( !visited[i] && conversion(word, words[i]) ) {
                //System.out.println(n + " " + minimum + " " + word + " " + words[i]);
                
                if ( words[i].equals(target) ) {
                    return Math.min(minimum, n + 1);
                }   

                visited[i] = true;
                int num = dfs(words[i], target, words, visited, n + 1, minimum, maximum);
                if ( num < minimum ) minimum = num;
                visited[i] = true;
            }
        }
        
        return minimum;
    }
    
    boolean conversion(String w1, String w2) {
        int tmp = 0;
        
        for (int i = 0; i < w1.length(); i++) {
            if ( w1.charAt(i) != w2.charAt(i) ) {
                tmp++;
                if ( tmp > 1 ) return false;
            }
        }
        
        return true;
    }
}