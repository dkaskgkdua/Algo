package programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueue2 {
    public static void operate(String op, PriorityQueue<Integer> pqMax, PriorityQueue<Integer> pqMin) {
        String cmd = op.split(" ")[0];
        int number = Integer.parseInt(op.split(" ")[1]);

        if( cmd.equals("I") ) {
            pqMax.add(number);
            pqMin.add(number);

        } else if( cmd.equals("D") ) {
            if( number == -1 ) { // 최소값
                pqMax.remove(pqMin.poll()); // minQueue에서 제거 -> maxQueue에서 제거
            }
            else if( number == 1 ) { // 최대값
                pqMin.remove(pqMax.poll()); // maxQueue에서 제거 -> minQueue에서 제거
            }
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pqMax = new PriorityQueue<>((i1,i2) -> i2-i1);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((i1,i2) -> i1-i2);

        for( String operation : operations ) {
            operate(operation, pqMax,pqMin);
        }

        answer[0] = pqMax.peek() == null ? 0 : pqMax.peek(); // 최대값
        answer[1] = pqMin.peek() == null ? 0 : pqMin.peek(); // 최소값

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16","D 1"};
        //String[] operations = {"I 7","I 5","I -5","D -1"};

        System.out.println(Arrays.toString(solution(operations)));
    }
}
