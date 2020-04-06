// https://programmers.co.kr/learn/courses/30/lessons/12938

class Solution {
  public int[] solution(int n, int s) {
      int[] answer = new int[n];
      
      if (s / n == 0) 
          return new int[]{-1};
      
      int tmp = n;
      for (int i = 0; i < n; i++) {
          answer[i] = s/tmp;
          s -= s/tmp;
          tmp--;
      }
      
      return answer;
  }
}