package SONG.LEVEL2.쇠막대기;

import java.util.LinkedList;
class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        char startBrace = '(', endBrace = ')';
        LinkedList<Character> queue = new LinkedList<>();

        for (int index = 0; index < arrangement.length(); index++) {
            if (arrangement.charAt(index) == startBrace && arrangement.charAt(index + 1) == endBrace) {
                answer += queue.size();
                index++;
                continue;
            }

            char brace = arrangement.charAt(index);

            if (brace == startBrace) {
                queue.add(brace);
            } else {
                queue.pollLast();
                answer++;
            }
        }

        return answer;
    }
}