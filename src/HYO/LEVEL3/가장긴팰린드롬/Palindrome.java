package programmers.level3;

// 완전탐색,? - 가장 긴 팰린드롬
// Programmers Lv.3
public class Solution {

    private static int findMax(String temp, int max) {
        int len = temp.length();
        int mid = len/2;

        for (int i = 0; i < mid; i++) {
            String s_front = temp.substring(i,mid);
            String s_back = (len % 2 == 0) ? temp.substring(mid,len-i) : temp.substring(mid+1,len-i);
            StringBuilder sb = new StringBuilder(s_back);
            //System.out.println(s_front + " " + s_back);

            if( sb.reverse().toString().equals(s_front) ) {
                max = Math.max(max,len-(2*i));
            }
        }

        return max;
    }

    public static int solution(String s) {
        int length = s.length();

        if (length == 0)   return 0;
        if (length == 1)   return 1;

        int left_max = 1; int right_max = 1;
        for (int idx = length; idx >= 0; idx--) {
            left_max = findMax(s.substring(0,idx),left_max);
            right_max = findMax(s.substring(idx,length),right_max);
        }

        return Math.max(left_max, right_max);
    }

    public static void main(String[] args) {
        //String s = "abcdcba";
        //String s = "abacde";
        //String s = "aba";
        // String s = "yeiwabba";
        String s = "ddaaddiayyyyuuoqzlxi";

        //System.out.println(isPalindrome("abbba"));
        //System.out.println(s.length()/2);
        //System.out.println(s.charAt(s.length()/2));

        //int len = s.length();
        //int mid = len % 2 == 0 ? len/2 : len/2+1;

        //System.out.println(s.substring(0,mid));
        //System.out.println(s.substring(mid,s.length()));

        System.out.println(solution(s));
    }
}