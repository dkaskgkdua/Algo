package programmers.level3;

import java.util.Arrays;

public class WordConvertion {
    private static int n;
    private static int answer = Integer.MAX_VALUE;

    public static boolean check(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if( str1.charAt(i) != str2.charAt(i) )
                count += 1;
        }

        return count == 1 ? true : false;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] visit, int count) {
        if( begin.equals(target) ) {
            answer = Math.min(answer,count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if( !visit[i] && check(begin, words[i]) ) {
                visit[i] = true;
                dfs(words[i],target,words,visit,count+1);
                visit[i] = false;
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        if( !Arrays.asList(words).contains(target) )
            return 0;

        n = words.length;
        boolean[] visit = new boolean[n];

        dfs(begin,target,words,visit,0);

        return answer;
    }

    public static void main(String[] args) {
        //String begin = "hit"; String target = "cog"; String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        //String begin = "hit"; String target = "cog"; String[] words = {"hot", "dot", "dog", "lot", "log"};
        String begin = "hit"; String target = "hhh"; String[] words = {"hhh","hht"};
        System.out.println(solution(begin,target,words));
    }
}
