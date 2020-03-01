package programmers.level3;

import java.util.LinkedList;

// BFS/DFS - 네트워크
// Programmers Lv.3
public class Solution {

    private static void dfs( int idx, int n, int[][] com, boolean[] connected) {
        if( connected[idx] )
            return ;
        connected[idx] = true;

        for (int i = 0; i < n; i++) {
            if( !connected[i] && com[idx][i] == 1 ) {
                dfs(i,n,com,connected);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] connected = new boolean[n];
        for (int i = 0; i < n; i++) {
            if( !connected[i] ) {
                dfs(i,n,computers,connected);
                answer ++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        //int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        //int n = 10; int[][] computers = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 1}};

        System.out.println(solution(n,computers));
    }
}
