package kr.co.programmers.level2.lessons42588;

import java.util.Stack;
import java.util.Arrays;

/**
 * 1. �ڿ������� ž ũ�⸦ �о�´� 	i
 * 2. ���� ž ũ�⸦ �о�´�		j
 * 3. ž ũ�⸦ ���Ѵ�			prices[i] > prices[j]
 * 
 * @author YuZi
 *
 */
class Solution {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for (int i = heights.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		return answer;
	}
}