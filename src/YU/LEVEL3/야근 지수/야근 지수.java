// https://programmers.co.kr/learn/courses/30/lessons/12927#

import java.util.Arrays;

class Solution2 {
    public long solution(int n, int[] works) {
        int[] result = new int[works.length];
        int totalovertime = sumArr(works);
        totalovertime -= n; 
        int time = totalovertime;
        
        if (time <= 0) return 0;

        for (int i=0; i<works.length; i++) {
            result[i] = (works[i] < totalovertime/works.length)? works[i] : totalovertime/works.length;
            time -= result[i];
        }
        
        for (int i=0; i<works.length; i++) {
            if (time <= 0) break;
            if (works[i] > result[i]) {
                result[i]++;
                time--;
            }
            if (i == works.length - 1) i = -1;
        }
       
        return getTiredness(result);
    }
    
    long getTiredness(int[] works) {
        long sum = 0;
        for (int work : works) {
            sum += work * work;
        }
        return sum;
    }
    
    int sumArr(int[] works) {
        int sum = 0;
        for (int work : works) {
            sum += work;
        }
        return sum;
    }
}