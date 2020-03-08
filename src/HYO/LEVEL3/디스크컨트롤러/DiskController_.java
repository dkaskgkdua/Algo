package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    static class Disk implements Comparable<Disk> {
        int start;
        int time;
        public Disk(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Disk o) {
            if( this.time >= o.time ) // 오름차순
                return this.start - o.start;
            return this.time - o.time;
        }
    }

    public static int solution(int[][] jobs) {
        int len = jobs.length;

        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);

        PriorityQueue<Disk> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.add(new Disk(jobs[i][0], jobs[i][1]));
        }

        Disk first = pq.poll();
        int prev_end = first.start + first.time;
        int sum = first.time;

        while( !pq.isEmpty() ) {
            Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);

            Disk now = pq.poll();
            int start = now.start;
            int time = now.time;

            if( prev_end > start ) {
                //System.out.println("sum: " + sum);
                //System.out.println("prev_end: " + prev_end);
                sum += ((prev_end-start) + time);
                prev_end += time;

            } else {
                sum += time;
                prev_end = start + time;

            }
        }
        System.out.println(sum);

        return (int) sum/len;
    }

    public static void main(String[] args) {
        //int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        //int[][] jobs = {{1, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{10, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(jobs));
    }
}
