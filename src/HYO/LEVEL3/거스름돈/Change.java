package programmers.level3;

public class Change {
    public static int solution(int n, int[] moneys) {
        int[] dp = new int[n+1];
        dp[0] = 1; // 거스름돈 단위 init default 값

        // dp[1,2,3,~]: 거스름돈으로 만들 수 있는 갯수
        for(int money : moneys ) {
            for(int i=money; i<=n; i++) {
                dp[i] += dp[i-money];
                dp[i] %= 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; int[] money = {1,2,5};

        System.out.println(solution(n,money));

    }
}
