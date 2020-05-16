package programmers.level3;

import java.util.Arrays;

// Greedy - 저울
// Programmers Lv.3
public class Scale {
    public static int solution(int[] weight) {
        Arrays.sort(weight);

        int answer = 0;
        for( int w : weight ) {
            if( answer + 1 < w ) break;
            answer += w;
            //System.out.println(w);
        }

        return answer+1;
    }

    public static void main(String[] args) {
        int[] weight = {3,1,6,2,7,30,1};
        //int[] weight = {3,1,1};

        System.out.println(solution(weight));
    }
}
