package kr.co.programmers.level2.lessons42583;
/* �̿ϼ� �ڵ� - ���� X */

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
        // ������ Ʈ���� ���� Ʈ���� ������ ���� ��� - true
        while(truck <= truck_weights.length) {
            time++;
            // Ʈ���� �ٸ��� �������� ���Կ��� ���ش�.
            int temp = bridge.poll();
            if(temp!=0) {
                truck++;
                truck_on_bridge -= temp;
            }
            // �ٸ� ���� Ʈ���� ���԰� weight���� ���� ���
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