package kr.co.programmers.level3.lessons12904;

/**
 * 가장 긴 팰린드롬
 * 문제 설명
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 *
 * 예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다.
 *
 * 제한사항
 * 문자열 s의 길이 : 2,500 이하의 자연수
 * 문자열 s는 알파벳 소문자로만 구성
 * 입출력 예
 * s	answer
 * abcdcba	7
 * abacde	3
 * 입출력 예 설명
 * 입출력 예 #1
 * 4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.
 *
 * 입출력 예 #2
 * 2번째자리 'b'를 기준으로 aba가 팰린드롬이 되므로 3을 return합니다.
 *
 * @see "https://programmers.co.kr/learn/courses/30/lessons/12904"
 */
public class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int currentPosition = 0; currentPosition < s.length(); currentPosition++) {
            answer = Math.max(answer, getMax(s, currentPosition - 1, currentPosition + 1, 1));

            if (currentPosition < s.length() - 1 && s.charAt(currentPosition) == s.charAt(currentPosition + 1)) {
                answer = Math.max(answer, getMax(s, currentPosition - 1, currentPosition + 2, 2));
            }
        }

        return answer;
    }

    private int getMax(String s, int start, int end, int count) {
        if (start < 0 || s.length() <= end || s.charAt(start) != s.charAt(end)) {
            return count;
        }

        return getMax(s, start - 1, end + 1, count + 2);
    }
}
