package HYO.LEVEL2.폰켓몬;

import java.util.*;

// ? - 폰켓몬
// Programmers Lv.2
public class Solution {
    public static int solution(int[] nums) {
        int answer = nums.length/2;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        answer = Math.min(set.size(),answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        //int[] nums = {3,3,3,2,2,4};
        //int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));
    }
}

