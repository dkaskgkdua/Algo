package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoldingPaper {

    /* 규칙
    1: 0
    2: 0 0 1
    3: 001 0 011
    4: 0010011 0 0011011
    5: 0010011 0 0011011 | 0~~~

    1) 중간값 1로 바꿈
    2) 0 붙이고
    3) 1번 이어 붙이기
     */
    public static int[] solution(int n) {
        if( n == 1 )
            return new int[] {0};

        List<Integer>[] DP = new ArrayList[n+1];
        DP[1] = new ArrayList<>(Arrays.asList(0));
        for (int i = 2; i <= n; i++) {
            List<Integer> temp = new ArrayList<>(DP[i-1]);
            temp.set(DP[i-1].size()/2, 1);

            DP[i] = new ArrayList<>(DP[i-1]);
            DP[i].add(0);
            DP[i].addAll(temp);
        }

        return toList(DP[n]);
    }

    private static int[] toList(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for( Integer value : list ) {
            ret[i++] = value;
        }
        return ret;
    }

    public static void main(String[] args) {
        //int n = 1;
        //int n = 2;
        //int n = 3;
        // int n = 4;
        int n = 20;
        System.out.println(Arrays.toString(solution(n)));
    }
}
