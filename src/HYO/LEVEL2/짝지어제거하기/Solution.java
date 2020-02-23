package HYO.LEVEL2.짝지어제거하기;

import java.util.Stack;

// Stack - 짝지어 제거하기
// Programmers Lv.2
public class Solution {

    public static int solution(String s)  {
        Stack<Character> st = new Stack<>();

        for( char ch : s.toCharArray() ) {
            if( !st.isEmpty() && ch == st.peek() )
                st.pop();
            else
                st.push(ch);
        }

        return st.isEmpty() ? 1 : 0;
    }

    // 시간 초과
    /*
    public static int solution(String s) {
        int cnt = 0;
        while( !s.equals("") ) {
            String s_temp = s;
            for (int i = 0; i < s.length(); i++) {
                System.out.println("[" + s + "]");
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    s = s.substring(0, i) + s.substring(i + 2, s.length());
                }
                System.out.println("{" + s + "}");
            }
            if( s.equals(s_temp) ) cnt++;
            if( cnt > 0 ) break;
        }

        return cnt == 0 ? 1 : 0;
    }
    */
    public static void main(String[] args) {
        String s = "baabaa";
        //String s = "cdcd";
        //String s = "aabba";

        //System.out.println(s.substring(0,1) + s.substring(3,s.length()));
        System.out.println(solution(s));
    }
}
