// https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size;
        
        for ( String operation : operations ) {
            char oper = operation.charAt(0);
            int num = Integer.parseInt(operation.substring(2, operation.length()));
            
            if ( oper == 'I' ) {
                // 추가
                pq.add(num);
            } else if ( oper == 'D' && pq.size() > 0) {
                if ( num == 1 ) {
                    // 최댓값 삭제
                    pq = removeMax(pq);
                } else {
                    // 최솟값 삭제
                    pq.poll();
                }
            }
            
            //System.out.println(pq.toString());
        }
        
        // 최댓값, 최소값 반환
        if ( pq.size() >= 2 ) {
            answer[1] = pq.poll();
            size = pq.size() - 1;
            for (int i = 0; i < size; i++) {
                pq.poll();
            }
            answer[0] = pq.poll();
        } else if ( pq.size() == 1 ) {
            answer[0] = pq.poll();
        }
        
        return answer;
    }
    
    PriorityQueue<Integer> removeMax(PriorityQueue<Integer> pq) {
        PriorityQueue<Integer> removedMax = new PriorityQueue<>();
        int size = pq.size() - 1;
        
        for (int i = 0; i < size; i++) {
            removedMax.add(pq.poll());
        }
        
        return removedMax;
    }
}