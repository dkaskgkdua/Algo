import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String [] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 0;

        for (int value : map.values()) {
            answer = answer + value + (answer * value);
        }

        return answer;
    }
}