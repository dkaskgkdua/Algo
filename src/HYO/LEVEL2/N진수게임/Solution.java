package HYO.LEVEL2.N진수게임;

// ? - N진수 게임
// Programmers Lv.2
public class Solution {
    public static char[] convert(int n, int value) {
        if( value == 0 ) return new char[] {'0'};

        StringBuilder sb = new StringBuilder();
        while( value > 0 ) {
            int rest = value % n;

            if( rest >= 10 )    sb.append((char)(65+(rest-10)));
            else                sb.append(rest);

            // sb.append(rest >= 10 ? (char)(65+(rest-10)) : rest);
            value /= n;
        }

        return sb.reverse().toString().toCharArray();
    }

    public static String solution(int n, int t, int m, int p) {
        String caseAll = "";
        int index = 0;
        for (int i = 0; i < t*m; i++) {
            char[] charNum = convert(n,i);  // 1) 0 ~ t*m N진수로 변환
            for (char ch : charNum) {   // 2) 일단 모든 경우의 수(t*m) 배열에 넣음
                if( index > t*m )   break;
                caseAll += ch;
                index ++;
            }
        }

        // 3) 튜브의 차례에 맞는 출력 프로그램
        char[] toCharCase = caseAll.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for( char ch : toCharCase ) {
            i++;

            // 튜브 차례
            if( i == p )    sb.append(ch);
            // 구할 숫자의 갯수 이상일 때, break
            if( sb.length() >= t ) break;
            // 한 턴
            if( i == m )    i = 0;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //int n = 2; int t = 4; int m = 2; int p = 1;
        //int n = 16; int t = 16; int m = 2; int p = 1;
        int n = 16; int t = 16; int m = 2; int p = 2;

        System.out.println(solution(n,t,m,p));
    }
}
