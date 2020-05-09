package programmers.level1;

import java.util.*;

/***
 * 카카오 인형뽑기
 */
public class PickDoll {
    private static void print(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int n = board.length;
        for(int move : moves) {
            int j = move - 1;

            int i = 0;
            while( board[i++][j] == 0 ) {
                if( i == n ) break;
            }

            if( board[i-1][j] == 0 ) continue;

            if( !stack.isEmpty() && stack.peek() == board[i-1][j] ) {
                stack.pop();
                board[i-1][j] = 0;
                answer += 2;

            } else {
                stack.add(board[i-1][j]);
                board[i-1][j] = 0;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}; int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board,moves));

    }
}
