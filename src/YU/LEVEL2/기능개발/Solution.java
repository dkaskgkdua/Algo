package kr.co.programmers.level2.lessons42586;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> time = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            time.offer((100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i]!=0? 1 : 0));
        }
        System.out.println("time : " + time.toString());
        int check = 1;
        while(!time.isEmpty()) {
            int num = time.poll();
            while(time.peek()!=null && num>=time.peek()) {
                check++;
                num = time.poll();
            }
            answer.add(check);
            check = 1;
        }
        System.out.println("answer : " + answer.toString());
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}