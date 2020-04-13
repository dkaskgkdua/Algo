// https://programmers.co.kr/learn/courses/30/lessons/12978
// 배달

import java.util.Arrays;

class Solution {
    public int answer = 0;
    public int leng;
    public int[][] map;
    public boolean[] check;
    
    public int solution(int N, int[][] road, int K) {
        boolean[] visit = new boolean[N+1];
        check = new boolean[N+1];
        map = new int[N+1][N+1];
        leng = N;
        visit[1] = true;
        
        for (int[] r : road) {
            if (map[r[0]][r[1]] != 0 && map[r[0]][r[1]] < r[2]) {
                 continue;
            }
            
            map[r[0]][r[1]] = r[2];
            map[r[1]][r[0]] = r[2];
        }

        dfs(1, visit, 0, K);

        return answer;
    }
    
    void dfs(int location, boolean[] visit, int distance, int K) {
        if (distance > K) {
            return;
        }
        
        if (check[location] != true) {
            answer++;
            check[location] = true;
        }
        
        for (int i = 1; i <= leng; i++) {
            if (visit[i] != true && map[location][i] != 0) {
                visit[i] = true;
                dfs(i, visit, distance + map[location][i], K);
                visit[i] = false;
            }
        }
    }
}