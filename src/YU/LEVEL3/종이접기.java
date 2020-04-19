// https://programmers.co.kr/learn/courses/30/lessons/62049
// 테스트 케이스 17번만 실패

import java.util.ArrayList;
import java.util.List;

class Solution {

	public int[] solution(int n) {
		List<Integer> answerList = new LinkedList<>();
		int[] routine = { 0, 0, 0, 1 };
		answerList.add(0);

		for (int round = 2; round <= n; round++) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 1; i < Math.pow(2, round); i++) {
				tmp.add((i % 2 == 0)? answerList.remove(0) : routine[i % 4]);
			}
			answerList = tmp;
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}