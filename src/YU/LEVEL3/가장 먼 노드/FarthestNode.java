
public class FarthestNode {
    public int farthestNode(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n+1];
        int nowDist = 1;
        int node = 1;
        
        boolean[][] map = new boolean[n+1][n+1];
        for (int[] e : edge) {
            map[e[0]][e[1]] = true;
            map[e[1]][e[0]] = true;
        }
        
        dist[1] = -1;
        for (int i = 2; i <= n; i++) {
            if (map[1][i]) {
                dist[i] = 1;
                node++;
            }
        }
        
        while (n > node) {
            // 해당 길이인 node에 대하여
            for (int i = 1; i <= n; i++) {
                if (dist[i] == nowDist) {
                    // 해당 node와 연결되었으며, 길이는 설정되어 있지 않은 node를 찾아서 길이+1을 설정
                    for (int j = 1; j <= n; j++) {
                        if (map[i][j] && dist[j] == 0) {
                            dist[j] = nowDist + 1;
                            node++;
                        }
                    }
                }
            }

            nowDist++;
        }
        
        for (int i = 2; i <= n; i++) {
            if (dist[i] == nowDist) {
                answer++;
            }
        }
        
        return answer;
    }
}
