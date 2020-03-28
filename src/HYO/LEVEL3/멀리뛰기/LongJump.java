package programmers.level3;

public class LongJump {

    public static long solution(int n) {
        if( n == 1 ) return 1;
        if( n == 2 ) return 2;

        long[] dp = new long[n+1];
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            // System.out.println(dp[i-2] + " " + dp[i-1] + " " + dp[i]);
            dp[i] %= 1234567L;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        //int n = 4;
        //int n = 3;
        //int n = 2000;
        int n = 1;
        //int n = 2;

        System.out.println(solution(n));
    }
}
