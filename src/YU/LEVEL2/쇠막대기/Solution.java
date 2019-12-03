package kr.co.programmers.level2.lessons42585;

import java.util.Stack;
class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> bar = new Stack<>();
        // 레이저 위치
        int index = arrangement.indexOf("()", 0);
        for(int i=0; i<arrangement.length(); i++) {
        	// 레이저라면 : answer += 막대기 수
            if(i==index) { 
                answer += (bar.size()!=0)? bar.peek() : 0;
                index = arrangement.indexOf("()", index+1);
                i++;
            }
            // 열린 괄호라면 : 막대기수++
            else if(arrangement.charAt(i) == '(') {
                bar.push(bar.size()+1);
                answer++;
            }
            // 닫힌 괄호라면 : 막대기수--
            else if(arrangement.charAt(i) == ')') bar.pop();
            //System.out.println("i : " + i + ", answer : " + answer + ", bar : " + bar.toString());
        }
        return answer;
    }
}