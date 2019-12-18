package YU.LEVEL2.Å¸°Ù³Ñ¹ö;

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
            // ?”?•˜ê¸?
            getTarget(numbers, index+1, is_target+numbers[index], target);
            // ë¹¼ê¸°
            getTarget(numbers, index+1, is_target-numbers[index], target);
        }
    }
}