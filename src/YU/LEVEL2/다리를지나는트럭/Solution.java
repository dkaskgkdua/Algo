package kr.co.programmers.level2.lessons42583;

import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, truck_on_bridge = 0, truck = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truckWeigths =  Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));
        for(int i=0; i<bridge_length; i++) bridge.offer(0);
        // 트럭이 다 지나갈 때까지
        while(truck != truck_weights.length) {
            time++;
            // 트럭이 다리를 지나가면 무게에서 빼준다.
            int passedTruck = bridge.poll();
            if(passedTruck!=0) {
                truck++;
                truck_on_bridge -= passedTruck;
            }
            // 다리 위의 트럭의 무게에서 다음 트럭의 무게의 합이 weight보다 작은 경우
            if(truckWeigths.size()!=0 && truck_on_bridge+truckWeigths.peek()<=weight) {
                bridge.offer(truckWeigths.peek());
                truck_on_bridge += truckWeigths.poll();
            } else {
                bridge.offer(0);
            }
        }
        return time;
    }
}