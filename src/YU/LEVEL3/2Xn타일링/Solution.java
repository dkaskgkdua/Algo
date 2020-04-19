// https://programmers.co.kr/learn/courses/30/lessons/12900

import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        // n = 1, answer = 1
        // n = 2, answer = 2
        // n = 3, answer = 3
        // n = 4, answer = 5
        // n = 5, answer = 8
        
        // ...
        
        // n = N, answer = arr[n] + arr[n-1]
        
        int num = 1;
        int num_1 = 1;
        for (int i = 1; i < n; i++) {
            answer = (num + num_1) % 1_000_000_007;
            
            num_1 = num;
            num = answer;
        }
        
        return answer;
    }
}