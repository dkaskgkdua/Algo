package programmers.level3;

public class Immigration {
    // 기준 : 모든 사람이 심사를 받는게 걸리는 최소 시간
    public static boolean check( int[] a, int n, long mid) {
        long cnt = n;
        for(int i=0; i<a.length; i++) {
            cnt -= mid/a[i];
            if (cnt < 0 ) break;
        }

        return cnt > 0 ? true : false;
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        long l = 0;
        long r = 1000000000L * 1000000000L;
        while( l <= r ) {
            long mid = (l+r) / 2;

            if( check(times,n,mid) ) {
                l = mid + 1;

            } else {
                r = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6; int[] times = {7,10};

        System.out.println(solution(n,times));
    }
}
