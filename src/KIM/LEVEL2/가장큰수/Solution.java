package kr.co.programmers.level2.lessons42746;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> -Integer.compare(Integer.valueOf(x + y), Integer.valueOf(y + x)))
                .collect(Collectors.joining());

        return new BigInteger(answer).toString();
    }
}