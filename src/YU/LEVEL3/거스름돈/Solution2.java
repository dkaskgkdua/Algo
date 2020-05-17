// https://programmers.co.kr/learn/courses/30/lessons/12907
// DP

// 풀이 : https://gurumee92.tistory.com/64

class Solution2 {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        long[] dp = new long[n+1];
        
        for (int i = 0; i <= n; i++) {
            dp[i] = (i % money[0] == 0) ? 1 : 0;
        }
        
        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j-money[i]];
            }
        }
        
        answer = (int)(dp[n] % 1000000007);
        
        return answer;
    }
}