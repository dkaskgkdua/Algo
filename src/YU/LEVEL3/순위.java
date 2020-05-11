// https://programmers.co.kr/learn/courses/30/lessons/49191
// 실패

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] scores = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        if ( n == 1 ) return 1;
        
        // 기본 점수판 생성
        for ( int[] result : results ) {
            scores[result[0]-1][result[1]-1] = 1;
            scores[result[1]-1][result[0]-1] = -1;
        }
        
        // dfs를 통해서 점수판을 다 채운 후, 등수가 변하는지 확인한다
        dfs(score, 0, 0, visited)
        
        return answer;
    }
    
    boolean[] dfs(int[][] score, int nodeX, int nodeY, boolean[][] visited) {
        visited[node] = true;
        
        if (nodeX == nodeY) {
            nodeX++;
            nodeY = 0;
        }

        if (score[nodeX][nodeY] != 0) {
            visited = dfs(score, idx, visited);
        }
        
        visited[nodeX][nodeY] = true;
            
        
        return visited;
    }
}