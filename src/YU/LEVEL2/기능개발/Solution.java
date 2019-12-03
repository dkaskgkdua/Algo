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
            time.offer((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
        System.out.println("time : " + time.toString());
        
        while(!time.isEmpty()) {
            int check = 1;
            int num = time.poll();
            while(time.size()!=0 && num>=time.peek()) {
                check++;
                time.poll();
            }
            answer.add(check);
        }
        System.out.println("answer : " + answer.toString());
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}