// https://programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // answer : 집에서 학교까지 갈 수 있는 최단 경로의 개수
        // m, n : 경로의 크기
        // pubbles : 장애물의 위치
        
        // 해당 문제에 대한 규칙을 찾아서 {모든 경로 - 해당 위치를 지나는 경로} 구하기
        // 경로 법칙 route[i][j] = route[i-1][j] + route[i][j-1]

        // 초기화
        int[][] routes = new int[n+1][m+1];
        routes[1][0] = 1;
        
        // 웅덩이 -1로 설정 (x축, y축 주의하기)
        for (int[] puddle : puddles) {
            routes[puddle[1]][puddle[0]] = -1;
        }
        
        // 경로 계산
        for (int i = 1; i <= n; i++) {         
            for (int j = 1; j <= m; j++) {
                if (routes[i][j] == -1)
                    routes[i][j] = 0;
                else
                    routes[i][j] = (routes[i-1][j] + routes[i][j-1]) % 1_000_000_007;
            }
        }

        return routes[n][m];
    }
}