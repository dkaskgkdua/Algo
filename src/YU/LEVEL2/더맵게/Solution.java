package kr.co.programmers.level2.lessons42626;
/* 효율성 0점 */

import java.util.Arrays;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = addScoville(scoville, K, 0);
        return answer!=0? answer : -1;
    }
    int addScoville(int[] scoville, int K, int num) {
        Arrays.sort(scoville);
        if((scoville.length <= 1) && (scoville[0] < K)) return -1;
        if(scoville[0] < K) {
            scoville[1] = scoville[0] + scoville[1] * 2;
            num++;
            num = addScoville(Arrays.copyOfRange(scoville, 1, scoville.length), K, num);
        }
        return num;
    }
}