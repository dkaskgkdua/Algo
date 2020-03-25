package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;

public class HanoiTop {
    static ArrayList<int[]> answerList = new ArrayList<>();

    public static void hanoi(int i, int from, int mid, int to){
        if( i == 1 ) {
            answerList.add(new int[]{from,to});
        } else {
            hanoi(i-1, from, to, mid);
            answerList.add(new int[]{from,to});
            hanoi(i-1, mid, from, to);
        }
    }

    public static int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[answerList.size()][2];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main (String [] args) {
        int n = 2;

        int[][] ans = solution(n);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
