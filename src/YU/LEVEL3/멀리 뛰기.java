// https://programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
  public long solution(int n) {
      long answer = 0;
      long n1 = 1;
      long n2 = 2;
      
      if ( n < 3 ) {
          answer = n;
      } else {
          for (int i = 3; i <= n; i++) {
              answer = n1 + n2;
              n1 = n2;
              n2 = answer;
              
              if ( n1 > 1234567) {
                  n1 %= 1234567;
                  n2 %= 1234567;
              }
          }
      }
      
      return answer % 1234567;
  }
}