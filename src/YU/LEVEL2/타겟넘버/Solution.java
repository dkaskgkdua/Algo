package YU.LEVEL2.Ÿ�ٳѹ�;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        getTarget(numbers, 0, 0, target);
        return answer;
    }
    void getTarget(int[] numbers, int index, int is_target, int target) {
        if(index == numbers.length) {
            if(is_target == target) answer++;
        } else {
            // ?��?���?
            getTarget(numbers, index+1, is_target+numbers[index], target);
            // 빼기
            getTarget(numbers, index+1, is_target-numbers[index], target);
        }
    }
}