// https://programmers.co.kr/learn/courses/30/lessons/12900
// 실패 코드
// 팩토리얼 수의 크기가 너무 커져서 overflow됨

import java.util.Arrays;

class Solution {
  public int solution(int n) {
      int answer = 1;
      // 숫자 n을 1과 2로 나누는 방법
      
      // 1 n개, 2 0개인 경우
      // 1 n-2개, 2 1개인 경우
      // ...
      // 1 0개, 2 n/2개인 경우

      // 위에 대한 모든 경우의 수에 대해서 구하기

      // 1 n개, 2 m개라고 했을 때, 
      // 경우의 수 : (n+m)!/(n!*m!)

      int vertical = n;
      int horizental = 0;

      int[] factorial = new int[n + 1];
      factorial[0] = 1;
      for (int i = 1; i <= n; i++) {
        factorial[i] = factorial[i-1] * i;
      }
      
      while ( vertical >= 2 ) {
        answer += (factorial[vertical+horizental] / (factorial[vertical] * factorial[horizental])) % 1000000007;
          
        vertical -= 2;
        horizental++;
      }
      
      if (vertical == 1) {
          answer += horizental;
      } else {
          answer++;
      }
      
      return answer;
  }
}