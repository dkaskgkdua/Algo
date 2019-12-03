package SONG.LEVEL2.올바른괄호;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static void main(String args[]) {
		Solution s = new Solution();

		System.out.print(s.solution("()()"));
		System.out.print(s.solution(")()("));
	}

	public boolean solution(String a) {
		StringBuilder aa = new StringBuilder();
		aa.append(a);
		char[] bb = a.toCharArray();
		int sum = 0;
		for(char b : bb) {
			if (b == '(') {
				sum++;
			} else {
				sum--;
			}
			if(sum < 0) return false;
		}
		
		/*
		
		for (int i = 0; i < aa.length(); i++) {
			if (sum < 0) {
				return false;
			}
			if (aa.charAt(i) == '(') {
				sum += 1;
			} else {
				sum -= 1;
			}
		}
		*/
		return (sum == 0);

	}
}