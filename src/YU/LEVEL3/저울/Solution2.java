// 성공

import java.util.Arrays;

class Solution2 {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        int sum = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if (sum < weight[i]) break;
            sum += weight[i];
        }
        return sum + 1;
    }
}