package programmers.level3;

import java.util.*;

// dfs - 여행경로
// Programmers Lv.3
public class TravelRoute {
    static ArrayList<String> list = new ArrayList<>();

    public static void dfs(String[][] tickets, StringBuilder route, boolean[] visit, String end, int cnt) {
        route.append(end+",");

        // System.out.println("cnt = " + cnt + ",tickets.length="+ tickets.length);
        if(cnt == tickets.length) {
            //System.out.println(route.toString());
            list.add(route.toString());
            return ;
        }

        for(int i=0; i<tickets.length; i++) {
            if( !visit[i] && end.equals(tickets[i][0]) ) {
                visit[i] = true;
                dfs(tickets,route,visit,tickets[i][1],cnt+1);

                visit[i] = false;
                route.setLength(route.length()-4);
            }
        }

    }

    public static String[] solution(String[][] tickets) {
        int n = tickets.length;

        // route += "ICN,";
        for(int i=0; i<n; i++) {
            boolean [] visit = new boolean[n];
            StringBuilder route = new StringBuilder();

            if( !visit[i] && tickets[i][0].equals("ICN") ) {
                visit[i] = true;
                route.append(tickets[i][0] + ",");
                dfs(tickets,route,visit,tickets[i][1],1);
            }
        }

        Collections.sort(list);
        return list.get(0).split(",");
    }

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }
}
