package HYO.LEVEL2.JadenCase���ڿ������;

// ���ڿ� - JadenCase ���ڿ� �����
// Programmers Lv.2
public class Solution {
    public static String solution(String s) {
        String answer = "";

        char[] toChar = s.toLowerCase().toCharArray();  // toLowerCase() �ʱ�ȭ
        boolean isFirst = true;
        for( char ch : toChar ) {
            answer += isFirst ? String.valueOf(ch).toUpperCase() :  String.valueOf(ch); // ù�����϶��� toUpperCase()
            isFirst = ch == ' ' ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        //String s = "3people unFollowed me";
        //String s = "for the last week";
        //String s = "3People";
        //String s = "FOR THE LAST WEEK";
        //String s = "q";
        //String s = "1";
        String s = "a1AAA asd2EEE   eE1 ";

        System.out.println(solution(s));
    }
}
