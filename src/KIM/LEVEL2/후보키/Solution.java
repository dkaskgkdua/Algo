package kr.co.programmers.kakao2019.lessons42890;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] relation) {
        int x = relation.length;
        int y = (int) Math.pow(2, relation[0].length) - 1;
        String[][] powerSetArray = new String[x][y];
        int count = 0;

        for (String[] arr : relation) {
            powerSetArray[count++] = this.bit(arr);
        }

        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        exit:
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (!set.add(powerSetArray[i][j])) {
                    set.clear();
                    continue exit;
                }
            }

            list.add(powerSetArray[x - 1][j]);
            set.clear();
        }

        List<List<String>> list2 = list.stream().map(l -> Arrays.asList(l.split("_"))).collect(Collectors.toList());
        List<List<String>> list3 = list2.stream().collect(Collectors.toList());

        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                if (list2.get(j).containsAll(list2.get(i))) {
                    list3.remove(list2.get(j));
                }
            }
        }

        return list3.size();
    }

    private String[] bit(String[] arr) {
        int n = arr.length;
        String[] powerSet = new String[(int) Math.pow(2, n) - 1];

        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    if (powerSet[i - 1] == null) powerSet[i - 1] = "";
                    powerSet[i - 1] += "[" + j + "]" + arr[j] + "_";
                }
            }
        }

        return powerSet;
    }
}
