package programmers.level3;

public class eXnTiling {
    public static int solution(int n) {
        int[] d = new int[n+1];

        d[0] = 1;
        d[1] = 1;
        for(int i=2; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 1000000007;
        }

        return d[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
