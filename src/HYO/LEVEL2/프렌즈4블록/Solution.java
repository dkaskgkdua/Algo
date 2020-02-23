package HYO.LEVEL2.프렌즈4블록;

import java.util.Arrays;

public class Solution {
    public static boolean  canRemove(char block, int i, int j, char[][] board) {
        return block != ' ' && block == board[i+1][j] && block == board[i][j+1] && block == board[i+1][j+1];
    }

    public static int getRemoveCount(int m, int n, char[][] board, int[][] removedBoard) {
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                char block = board[i][j];
                if( canRemove(block, i,j,board) ) {
                    removedBoard[i][j] = 1;
                    removedBoard[i+1][j] = 1;
                    removedBoard[i][j+1] = 1;
                    removedBoard[i+1][j+1] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.print(removedBoard[i][j] + " ");
                if( removedBoard[i][j] > 0 ) {
                    board[i][j] = ' ';
                    count += removedBoard[i][j];
                }
            }
            // System.out.println();
        }
        // System.out.println("count: " + count);
        return count;
    }

    public static void relocate(int m, int n, char[][] board, int[][] removedBoard) {
        while( true ) {
            boolean isOver = false;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (removedBoard[j][i] == 1 && board[j - 1][i] != ' ') {
                        int cntTemp = removedBoard[j][i];
                        removedBoard[j][i] = removedBoard[j - 1][i];
                        removedBoard[j - 1][i] = cntTemp;

                        char boardTemp = board[j][i];
                        board[j][i] = board[j - 1][i];
                        board[j - 1][i] = boardTemp;

                        isOver = true;
                    }
                }
            }
            if( !isOver ) break;
        }

        /*System.out.println("removedBoard");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(removedBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("charBoard");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(charBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/
    }

    public static int removeNrelocate(int m, int n, char[][] board) {
        int removeCount = 0;
        int[][] removedBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(removedBoard[i], 0);
        }

        // 1) 지우기
        removeCount = getRemoveCount(m,n,board,removedBoard);
        // 2) 빈공간 채우기
        relocate(m,n,board,removedBoard);

        return removeCount;
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] charBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        int count = -1;
        while( count != 0 ) {
            count = removeNrelocate(m,n,charBoard);
            answer += count;
        }

        return answer;
    }

    public static void main(String[] args) {
        //int m = 4; int n = 5; String[] board = 	{"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int m = 6; int n = 6; String[] board = 	{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(m,n,board));
    }
}

