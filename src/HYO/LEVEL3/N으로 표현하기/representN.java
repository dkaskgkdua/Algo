package programmers.level3;

public class representN {
    static int answer = -1;

    public static int increaseN(int value, int N) {
        return value * 10 + N;
    }

    public static void dfs(int N, int number, int cnt, int prev) {
        int temp = N;

        if( number == prev ) {
            if( answer == -1 || answer > cnt ) {
                answer = cnt;
            }
            return;
        }

        for(int i=0; i< 8-cnt; i++) {
            dfs(N,number,cnt+i+1,prev + temp);
            dfs(N,number,cnt+i+1,prev - temp);
            dfs(N,number,cnt+i+1,prev * temp);
            dfs(N,number,cnt+i+1,prev / temp);

            temp = increaseN(temp, N);
        }
    }

    public static int solution(int N, int number) {
        dfs(N,number,0,0);

        return answer;
    }

    public static void main(String[] args) {
        int n = 5; int number = 12;
        //int n = 2; int number = 11;

        System.out.println(solution(n,number));
    }
}