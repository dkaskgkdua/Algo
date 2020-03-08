package programmers.level3;

import java.util.*;

// Heap - 디스크 컨트롤러
// Programmers Lv.3
public class DiskController {
    static class Disk implements Comparable<Disk> {
        int requestTime;
        int taskTime;
        public Disk(int requestTime, int taskTime) {
            this.requestTime = requestTime;
            this.taskTime = taskTime;
        }

        @Override
        public int compareTo(Disk o) {
            return this.taskTime - o.taskTime;
        }
    }

    public static int solution(int[][] jobs) {
        int len = jobs.length;


        Arrays.sort(jobs, (o1,o2) ->
                o1[1] == o2[1] ? o1[1] - o2[1] : o1[0] - o2[0] ); // 요청 시간([0])에 대하여 오름차순 정렬( 요청 시간이 동일한 경우, 작업 시간에 따라 오름차순 정렬)
        List<Disk> jobList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            jobList.add(new Disk(jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Disk> waitingJob = new PriorityQueue<>(); // 대기 큐
        int prev_end = 0;
        int sum = 0;
        while( !jobList.isEmpty() || !waitingJob.isEmpty() ) {
            boolean isNew = false;

            // 요청 시간이 이전에 끝난 시간보다 더 크면 waiting이 아님.
            Iterator<Disk> iter = jobList.iterator();
            while( iter.hasNext() ) {
                Disk job = iter.next();
                if( job.requestTime > prev_end ) break;

                waitingJob.add(job);
                iter.remove();
            }

            // 대기 요청이 없으면 가장 먼저 들어온 작업 수행!
            if( waitingJob.size() == 0 ) {
                waitingJob.add(jobList.get(0));
                jobList.remove(0);

                isNew = true;
            }

            Disk wJob = waitingJob.poll();
            // 기존에 대기하던 작업과 다른 새 작업은 계산 방법이 다르다.
            if( isNew ) {
                sum += wJob.taskTime;
                prev_end = wJob.requestTime + wJob.taskTime;

            } else {
                sum += ((prev_end-wJob.requestTime) + wJob.taskTime);
                prev_end += wJob.taskTime;

            }
        }

        return (int) sum/len;
    }

    public static void main(String[] args) {
        //int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{1, 3}, {1, 9}, {2, 6}};
        //int[][] jobs = {{10, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(jobs));
    }
}
