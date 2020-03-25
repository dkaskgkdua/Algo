package programmers.level3;

// DP - 타일 장식물
// Programmers Lv.3
public class TileDecoration {
    public static long solution(int N) {

        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // System.out.println(dp[N] + " " + dp[N-1]);

        return 2 * (dp[N]+dp[N-1]);
    }

    public static void main(String[] args) {
        int N = 5;
        //int N = 6;
        System.out.println(solution(N));
    }

}
