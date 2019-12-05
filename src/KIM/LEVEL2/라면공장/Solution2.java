package kr.co.programmers.level2.lessons42629;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0, next = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));

        while (true) {
            if (k <= stock) {
                break;
            }

            while (next < dates.length && stock >= dates[next]) {
                queue.add(supplies[next]);
                next++;
            }

            stock += queue.poll();
            answer++;
        }

        return answer;
    }
}


