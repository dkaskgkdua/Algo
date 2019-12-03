package kr.co.programmers.level2.lessons42626;
// PriorityQueue
import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int num = 0;
        PriorityQueue<Integer> orderedScoville = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) orderedScoville.add(scoville[i]);
        while(orderedScoville.size() > 1 && orderedScoville.peek() < K) {
            if(orderedScoville.peek() < K) {
                orderedScoville.add(orderedScoville.poll() + orderedScoville.poll() * 2);
                num++;
            }
        }
        return (orderedScoville.peek()>=K)? num : -1;
    }
}