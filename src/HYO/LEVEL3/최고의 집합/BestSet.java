package programmers.level3;

import java.util.Arrays;

// ? - 최고의 집합
// Programmers Lv.3
public class BestSet {

    public static int[] solution(int n, int s) {
        if( n > s )
            return new int[]{-1};

        int[] answer = new int[n];

        int v = s/n;
        int r = s%n;
        Arrays.fill(answer,v);
        // Arrays.stream(answer).forEach( a-> System.out.println(a));
        int idx = n-1;
        while( r-- > 0 ) {
            answer[idx--] += 1; // 오름차순으로 나타내기 위함
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 2; int s = 9;
        //int n = 2; int s = 1;
        //int n = 2; int s = 8;

        System.out.println(Arrays.toString(solution(n,s)));
    }
}
