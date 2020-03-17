// https://programmers.co.kr/learn/courses/30/lessons/43104

class Solution {
    public long solution(int N) {
        long n = 1;
        long n_1 = 1;
        
        for (int i = 1; i < N-1; i++) {
            long tmp = n;
            n = n + n_1;
            n_1 = tmp;
            
            //System.out.println("n : " + n + ", n-1 : " + n_1);
        }
        
        return 2 * (2 * n + n_1);
    }
}