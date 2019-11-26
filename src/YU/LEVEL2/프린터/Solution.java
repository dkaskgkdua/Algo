package kr.co.programmers.level2.lessons42587;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list - priorities�� List�� ��ȯ
 * loc 	- location�� ��ġ�� ǥ���ϴ� List
 * check- 0��° ���Ұ� ���� ū ���, �� ���Ҹ� �����ϱ� ���� ��ġ
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