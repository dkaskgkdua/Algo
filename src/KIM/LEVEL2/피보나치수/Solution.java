package kr.co.programmers.level2.lessons12945;

/**
 * 피보나치 수
 *
 * @see "https://programmers.co.kr/learn/courses/30/lessons/12945"
 */
public class Solution {
    int [] caches = new int[100_001];

    {
        this.caches[0] = 0;
        this.caches[1] = 1;
        this.caches[2] = 1;
    }

    /**
     * n번째 피보나치 수를 1234567로 나눈 나머지를 구하는 메서드
     * @param n n번째 피보니치 수
     * @return n번째 피보나치 수를 1234567로 나눈 나머지
     */
    public int solution(int n) {
        if (n == 0){
            return 0;
        }

        if (caches[n] != 0) {
            return caches[n];
        }

        return caches[n] = (solution(n - 1) + solution(n - 2)) % 1234567;
    }
}
