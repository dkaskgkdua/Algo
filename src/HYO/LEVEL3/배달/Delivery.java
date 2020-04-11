package programmers.level3;

import java.util.Arrays;

public class Delivery {

    static final int inf = 1000000000;
    public static int solution(int N, int[][] road, int K) {
        int n = N;
        int[][]a = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                a[i][j] = inf;
            }
        }

        for(int[] r : road) {
            if( a[r[0]][r[1]] > r[2] ) {
                a[r[0]][r[1]] = r[2];
            }
            if( a[r[1]][r[0]] > r[2] ) {
                a[r[1]][r[0]] = r[2];
            }
            // System.out.println(r[0]+ ","+r[1] + " = " +a[r[0]][r[1]]);
        }

        /*
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        */
        int[] d = new int[n+1];
        boolean[]c = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            d[i] = inf;
            c[i] = false;
        }

        int start = 1;
        d[start] = 0;
        for (int k=0; k<n-1; k++) { // n-1개
            // System.out.println(Arrays.toString(d));
            int min = inf+1;
            int x = -1;
            for (int i=1; i<=n; i++) {  // 체크되지 않은 것들 중 dist값이 가장 작은 것
                if ( !c[i] && min > d[i] ) {
                    min = d[i];
                    x = i;
                }
            }
            c[x] = true;
            for (int i=1; i<=n; i++) { // x: start
                if (d[i] > d[x] + a[x][i]) {
                    d[i] = d[x] + a[x][i];

                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i + " " + d[i]);
            if( d[i] <= K ) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5; int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}; int K = 3;
        //int N = 6; int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}; int K = 4;

        System.out.println(solution(N,road,K));
    }
}
