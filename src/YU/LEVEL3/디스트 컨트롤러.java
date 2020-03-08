// https://programmers.co.kr/learn/courses/30/lessons/42627

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        List<Job> waitingJobs = new ArrayList<>();
        
        sortArray(jobs);
        
        int total_waiting_time = 0;
        int time = jobs[0][0];

        // jobList 초기화
        for ( int[] job : jobs ) {
            Job j = new Job();
            j.request_time = job[0];
            j.task_time = job[1];
            
            jobList.add(j);
        }
        
        while ( !jobList.isEmpty() || !waitingJobs.isEmpty() ) {
            Job j = new Job();
            boolean chk = false;
            
            // 해당 시간까지 들어온 작업 추가
            while ( !jobList.isEmpty() ) {
                j = jobList.get(0);
                if ( j.request_time > time ) break;
                
                waitingJobs.add(j);
                jobList.remove(0);
            }

            // 정렬
            if (waitingJobs.size() != 0) {
                Collections.sort(waitingJobs);
            } else {
                waitingJobs.add(jobList.get(0));
                jobList.remove(0);
                
                chk = true;
            }
            
            // 작업시간이 가장 짧은 작업 빼기
            j = waitingJobs.get(0);
            waitingJobs.remove(0);
            
            if ( !chk ) {
                total_waiting_time += (time - j.request_time + j.task_time);
                time += j.task_time;
            } else {
                total_waiting_time += j.task_time;
                time = j.request_time + j.task_time;
            }
        }
        
        return total_waiting_time / jobs.length;
    }
    
    public class Job implements Comparable<Job> {
        int request_time;
        int task_time;
        
        @Override
        public int compareTo(Job o) {
            return this.task_time - o.task_time;
        }
        
        @Override
        public String toString() {
            return "[" + request_time + ", " + task_time + "]";
        }
    }
    
    public static void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
    }
}