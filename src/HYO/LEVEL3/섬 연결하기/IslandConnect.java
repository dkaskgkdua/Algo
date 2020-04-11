package programmers.level3;

import java.util.*;

// Greedy - 섬연결하기
// Programmers Lv.3
public class IslandConnect {
    /*
    public static int solution(int n, int[][] costs) {
        int answer = 0;

        int [][] bridge = new int[n][n];
        for(int i=0; i<costs.length; i++) {
            bridge[costs[i][0]][costs[i][1]] = bridge[costs[i][1]][costs[i][0]] = costs[i][2];
        }

        List<Integer> islands = new ArrayList<>();
        boolean[] visit = new boolean[n];
        islands.add(0);
        visit[0] = true;

        while( islands.size() < n ) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int island=0; island<islands.size(); island++) {
                int i = islands.get(island);
                for(int j=0; j<n; j++) {
                    if( !visit[j] && i != j && bridge[i][j] > 0 && bridge[i][j] < min ) {
                        min = bridge[i][j];
                        minIdx = j;
                    }
                }
            }
            visit[minIdx] = true;
            islands.add(minIdx);
            answer += min;
        }

        return answer ;
    }
    */

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;
        public Edge() {
            this(0,0,0);
        }

        public Edge(int s,int e,int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    // Kruskal algorithm 참고 - https://brenden.tistory.com/33
    private static int solution(int n, int[][] costs) {
        int ans = 0;

        int[] p = new int[n+1];
        for (int i=0; i<=n; i++) {
            p[i] = i;
        }

        ArrayList<Edge> a = new ArrayList<>();
        for( int[] cost : costs ) {
            a.add( new Edge(cost[0],cost[1],cost[2]));
        }
        Collections.sort(a);

        System.out.println("begin: "+Arrays.toString(p));
        for( Edge e : a ) {
            int x = find(p,e.start);
            //System.out.println("e[" + e.start + "," + e.end + "] - " + e.cost);
            //System.out.println(" end ====================");
            int y = find(p,e.end);

            //System.out.println("x= " + x + ", y= " + y);
            if( x != y ) {
                union(p,x,y);
                ans += e.cost;
            }
            System.out.println(Arrays.toString(p));
        }

        return ans;
    }

    // 찾기
    private static int find(int[] p, int a) {
        if( a == p[a] )
            return a;

        //System.out.println(a + " " + p[a]);
        return p[a] = find(p,p[a]);
    }

    // 연결
    private static void union(int[] p, int a, int b) {
        a = find(p,a);
        b = find(p,b);
        p[a] = b;
    }

    public static void main(String[] args) {
        int n = 4; int[][] costs = {{0,1,1},{0,2,5},{1,2,2},{1,3,1},{2,3,8}};
        //int n = 7; int[][] costs = {{1,2,2},{2,3,4},{2,5,1},{3,4,1},{4,2,3},{4,6,7},{4,7,5},{5,1,3},{6,7,2},{7,3,4}};

        System.out.println(solution(n,costs));
    }
}
