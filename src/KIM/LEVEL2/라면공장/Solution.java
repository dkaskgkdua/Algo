package kr.co.programmers.level2.lessons42629;

//import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Pair> queue = new PriorityQueue<Pair>();

        Queue<Pair> schedule = IntStream.range(0, dates.length)
                .mapToObj(index -> new Pair(dates[index], supplies[index]))
                .collect(Collectors.toCollection(LinkedList::new));

        while (stock < k) {
            while (!schedule.isEmpty() && stock >= schedule.peek().getKey()) {
                queue.add(schedule.poll());
            }

            stock += queue.poll().getValue();
            answer++;

        }

        return answer;
    }

    /*
    private int getMaxsupply(ArrayList<Pair> schedule) {
        Pair max = Collections.max(schedule, (first, second) -> first.getValue()  - second.getValue());
        schedule.remove(max);
        return max.getValue();
    }*/
}

class Pair implements Comparable<Pair>{
    private int key;
    private int value;

    Pair() {

    }

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair target) {
        return target.getValue() - this.getValue();
    }
}


