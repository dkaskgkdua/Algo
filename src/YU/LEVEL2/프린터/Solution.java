package kr.co.programmers.level2.lessons42587;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int solution(int[] priorities, int location) {
		List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
		List<Integer> loc = Arrays.stream(new int[priorities.length]).boxed().collect(Collectors.toList());
		loc.set(location, 1);
		while (!list.isEmpty()) {

			System.out.println("list : " + list.toString());
			System.out.println("loc : " + loc.toString());

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