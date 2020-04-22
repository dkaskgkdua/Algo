// https://programmers.co.kr/learn/courses/30/lessons/62049
// 통과

import java.util.LinkedList;
import java.util.List;

class Solution {

	public int[] solution(int n) {
        StringBuilder answerList = new StringBuilder();
		String[] routine = { "0", "0", "1", "0" };
        int max = 1;
        
        // answer
		answerList.append(0);
		for (int round = 2; round <= n; round++) {
            max = max * 2 + 1;
			for (int i = 0; i < max; i += 2) {
				answerList.insert(i, (i % 2 != 0)? answerList.charAt(i-1) : routine[i % 4]);
			}
		}
        
        // split
		int[] answer = new int[answerList.length()];
		for (int i = 0; i < answerList.length(); i++) {
			answer[i] = answerList.charAt(i) - '0';
		}

		return answer;
	}
}