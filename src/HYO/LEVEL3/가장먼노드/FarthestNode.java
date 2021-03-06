package programmers.level3;

import java.util.*;

// Graph - 가장 먼 노드
// Programmers Lv.3
public class FarthestNode {
    public static int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        boolean [][] map = new boolean[n+1][n+1];
        // int [][] map = new int[n+1][n+1];
        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
            //map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = 1;
        }

        /*
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        */

        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(1);

        int max = 0;
        while(!nodes.isEmpty()) {
            int i = nodes.poll();
            //System.out.println("i: " + i);

            for (int j = 2; j <= n; j++) {
                if( dist[j] == 0 && map[i][j] ) {
                    dist[j] = dist[i] + 1;
                    nodes.add(j);
                    max = Math.max(dist[j],max);
                    //System.out.println(Arrays.toString(dist));
                }
            }
        }

        //System.out.println(Arrays.toString(dist));
        int answer = 0;
        for (int i : dist) {
            if( max == i )
                answer ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6; int[][] edge = { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2} };

        System.out.println(solution(n,edge));
    }
}
