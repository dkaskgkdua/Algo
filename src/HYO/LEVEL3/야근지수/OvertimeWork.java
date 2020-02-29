package programmers.level3;

import java.util.PriorityQueue;

// Heap - 야근 지수
// Programmers Lv.3
public class Solution {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((w1, w2) -> w2 - w1);
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }

        while( n-- > 0 ) {
            //System.out.println(pq.peek().workload--);
            //System.out.println(pq.remove().workload);
            if( pq.isEmpty() ) break;
            int now = pq.poll();

            if ( !pq.isEmpty() && now > 0) {
                now--;
                if (now > 0) pq.offer(now);
            }
        }

        long answer = 0;
        while( !pq.isEmpty() ) {
            // System.out.println(pq.peek().workload);
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;

        /*
        int len = works.length;
        while( n-- > 0 ) {
            Arrays.sort(works);
            if( works[len-1] > 0 )
                works[len-1] -= 1;
        }

        System.out.println(Arrays.toString(works));
        for (int i = 0; i <len ; i++) {
            if( works[i] == 0 ) continue;
            answer += Math.pow(works[i],2);
        }
        */
    }

    public static void main(String[] args) {
        //int n = 4; int[] works = {4,3,3};
        //int n = 1; int[] works = {2,1,2};
        int n = 3; int[] works = {1,1};

        System.out.println(solution(n,works));
    }
}
