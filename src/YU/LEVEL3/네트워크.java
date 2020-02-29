// https://programmers.co.kr/learn/courses/30/lessons/43162

import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] network = new boolean[n];
        
        for (int node=0; node<n; node++) {
            if (!network[node]) {
                dfs(computers, node, network);
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean[] dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;
        
        for (int idx=0; idx<computers.length; idx++) {
            if (node != idx && computers[node][idx] == 1 && visited[idx] == false) {
                visited = dfs(computers, idx, visited);
            }
        }
        return visited;
    }
}