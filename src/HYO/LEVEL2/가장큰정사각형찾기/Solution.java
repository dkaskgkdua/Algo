package HYO.LEVEL2.가장큰정사각형찾기;

// 완탐, DP  - 가장 큰 정사각형 찾기
// Programmers Lv.2
public class Solution {
    /* DP */
    public static int solution(int [][]board) {
        // int answer = 0;

        int w_len = board.length;
        int h_len = board[0].length;

        int max = 0;
        for (int i = 0; i < w_len; i++) {
            for (int j = 0; j < h_len; j++) {
                if( board[i][j] == 1 )
                    max = 1;
            }
        }

        for (int i = 1; i < w_len; i++) {
            for (int j = 1; j < h_len; j++) {
                if( board[i][j] == 1 ) {
                    board[i][j] = Math.min( Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                    max = board[i][j] > max ? board[i][j] : max;
                }
            }
        }

        /*
        for (int i = 0; i < w_len; i++) {
            for (int j = 0; j < h_len; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        */

        return (int) Math.pow(max,2);
    }


    /* 시간초과
    public static boolean canMake(int [][]board, int i, int j, int len) {
        for (int x = i; x < i+len; x++) {
            for (int y = j; y < j+len; y++) {
                if( board[x][y] == 0 )
                    return false;
            }
        }

        return true;
    }

    public int solution(int [][]board)
    {
        int answer = 0;
        int len = board.length;

        for( ; len > 0; len -- ) {
            for (int i = 0; i < board.length-len+1; i++) {
                for (int j = 0; j < board[i].length-len+1; j++) {
                    if(canMake(board,i,j,len)) {
                        return answer = len*len;
                    }
                }
            }
        }

        return answer;
    }*/

    public static void main(String[] args) {
        int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        //int [][]board = {{0,0,1,1},{1,1,1,1}};

        System.out.println(solution(board));
    }
}
