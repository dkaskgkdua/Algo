package HYO.LEVEL2.Çà·ÄÀÇ°ö¼À;

// ¼öÇĞ - Çà·ÄÀÇ °ö¼À
// Programmers Lv.2
public class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length; int m = arr2[0].length;
        int[][] answer = new int[n][m];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < arr1[i].length; k++)
                    answer[i][j] += arr1[i][k]*arr2[k][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}}; int[][] arr2 = {{3,3},{3,3}};
        //int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}}; int[][] arr2 = {{5,4,3},{2,4,1},{3,1,1}};


        int[][] answer = solution(arr1,arr2);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

