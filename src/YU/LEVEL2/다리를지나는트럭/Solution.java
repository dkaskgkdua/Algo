package kr.co.programmers.level2.lessons42583;
/* 미완성 코드 - 실행 X */

import java.util.Queue;
import java.util.Arrays;
import java.util.Colletors;
import java.util.LinkedList;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, truck_on_bridge = 0, truck = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truckWeigths = Arrays.stream(truck_weights)
            .boxed()
            .collect(Colletors.toCollection(LinkedList::new));
        // 지나온 트럭의 수가 트럭의 수보다 작은 경우 - true
        while(truck <= truck_weights.length) {
            time++;
            // 트럭이 다리를 지나가면 무게에서 빼준다.
            int temp = bridge.poll();
            if(temp!=0) {
                truck++;
                truck_on_bridge -= temp;
            }
            // 다리 위의 트럭의 무게가 weight보다 작은 경우
            if(truckWeigths.peek() < weight) {
                bridge.offer(truckWeigths.peek());
                truck_on_bridge += truckWeigths.poll();
            } else {
                bridge.offer(0);
            }
        }
        return time;
    }
}