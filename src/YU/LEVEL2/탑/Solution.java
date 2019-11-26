package kr.co.programmers.level2.lessons42588;

import java.util.Stack;
import java.util.Arrays;

/**
 * 1. 뒤에서부터 탑 크기를 읽어온다 	i
 * 2. 비교할 탑 크기를 읽어온다		j
 * 3. 탑 크기를 비교한다			prices[i] > prices[j]
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