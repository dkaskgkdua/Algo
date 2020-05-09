package programmers.level3;

public class Budget {
    public static boolean check( int [] a, int m, int mid) {
        int sum = 0;
        for(int i=0; i<a.length; i++) {
            if( a[i] < mid ) {
                sum += a[i];
            } else {
                sum += mid;
            }
        }

        return sum <= m ? true : false;
    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;

        int max = 0;
        for(int i=0; i<budgets.length; i++) {
            max = Math.max(max, budgets[i]);
        }

        int l = 0;
        int r = max;
        while( l <= r ) {
            int mid = (l+r) / 2;

            if( check(budgets,M,mid) ) {
                l = mid + 1;
                answer = mid;
            } else {
                r = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150}; int M = 485;

        System.out.println(solution(budgets,M));
    }
}
