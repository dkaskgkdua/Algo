// https://programmers.co.kr/learn/courses/30/lessons/12907
// DP

// 풀이 : https://gurumee92.tistory.com/64
// 효율성 실패

class Solution1 {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        long[][] dp = new long[money.length][n+1];
        
        for (int i = 0; i <= n; i++) {
            dp[0][i] = (i % money[0] == 0) ? 1 : 0;
        }
        
        for (int i = 1; i < money.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                for (int coin = 1; coin <= j / money[i]; coin++) {
                    dp[i][j] += dp[i - 1][j - money[i] * coin];
                }
            }
        }
        
        answer = (int)(dp[money.length - 1][n] % 1000000007);
        
        return answer;
    }
}