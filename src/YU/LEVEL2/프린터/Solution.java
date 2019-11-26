package kr.co.programmers.level2.lessons42587;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list - priorities를 List로 변환
 * loc 	- location의 위치를 표시하는 List
 * check- 0번째 원소가 가장 큰 경우, 그 원소를 제거하기 위한 장치
 * 
 * @author YuZi
 *
 */
class Solution {
	public int solution(int[] priorities, int location) {
		List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
		List<Integer> loc = Arrays.stream(new int[priorities.length]).boxed().collect(Collectors.toList());
		while (!list.isEmpty()) {
			boolean check = true;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(0) < list.get(j)) {
					check = false;
					list.add(list.remove(0));
					loc.add(loc.remove(priorities.length - list.size()));
					break;
				}
			}
			if (check) list.remove(0);
		}
		return loc.indexOf(1) + 1;
	}
}