package programmers.level3;

import java.util.*;

class BadUser {
    private static boolean check(String a, String b) {
        if( a.length() != b.length() )
            return false;

        char[] char_a = a.toCharArray();
        char[] char_b = b.toCharArray();

        for (int i = 0; i < char_a.length; i++) {
            if( char_b[i] == '*' ) continue;

            if( char_a[i] != char_b[i] ) {
                return false;
            }
        }
        return true;
    }

    static Set<ArrayList<String>> answer = new HashSet<>();
    private static void dfs(String[] user_id, String[] banned_id, boolean[] visit_u, ArrayList<String> list, int cnt) {
        if( cnt >= banned_id.length ) { // dfs-백트래킹
            Collections.sort(list);
            answer.add(list);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {

            if( !visit_u[i] && check(user_id[i], banned_id[cnt]) ) {
                visit_u[i] = true;
                list.add(user_id[i]);
                dfs(user_id, banned_id, visit_u, list, cnt+1);
                list.remove(user_id[i]);
                visit_u[i] = false;
            }
        }
    }

    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] visit_u = new boolean[user_id.length];
        ArrayList<String> list = new ArrayList<>();
        dfs(user_id, banned_id, visit_u, list, 0);

        return answer.size();
    }

    public static void main(String[] args) {
        //String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" }; String[] banned_id = {"fr*d*", "abc1**"};
        //String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; String[] banned_id = {"*rodo", "*rodo", "******"};
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        //System.out.println(banned_id[3].replace("*", "[\\w\\d]"));
        System.out.println(solution(user_id,banned_id));
    }

}