package kr.co.programmers.level2.lessons42584;

public class Solution2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] > prices[j]) {
                    break;
                } else {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
