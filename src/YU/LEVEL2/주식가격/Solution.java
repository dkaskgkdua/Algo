package kr.co.programmers.level2.lessons42584;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if (prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
				answer[i] = prices.length - i - 1;
			}
		}
		return answer;
	}
}