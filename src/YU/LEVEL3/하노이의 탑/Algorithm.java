// https://www.youtube.com/watch?v=aPYE0anPZqI
// "하노이의 탑"을 재귀로 푸는 설명 영상

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<int[]> answerList = new ArrayList<>();
    
    public int[][] solution(int n) {    
        hanoi(n, 1, 3, 2);    
        int[][] answer = new int[answerList.size()][2];        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    void hanoi(int num, int from, int to, int other) {
        if (num == 0) return;
        hanoi(num - 1, from, other, to);
        answerList.add(new int[]{from, to});
        hanoi(num - 1, other, to, from);
    }
}