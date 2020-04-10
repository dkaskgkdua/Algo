package level3.lessons42579;

import java.util.*;

/**
 * 베스트앨범
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 *
 * @see "https://programmers.co.kr/learn/courses/30/lessons/42579"
 */
public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> countByGenre = new HashMap<>();
        Map<String, Queue<Album>> groupByGenre = new HashMap<>();
        Album temp;

        for (int order = 0; order < genres.length; order++) {
            temp = new Album(order, genres[order], plays[order]);
            countByGenre.put(temp.getGenre(), countByGenre.getOrDefault(temp.getGenre(), 0) + temp.getPlay());
            if (groupByGenre.containsKey(temp.getGenre())) {
                groupByGenre.get(temp.getGenre()).offer(temp);
            } else {
                Queue<Album>  value = new PriorityQueue<>();
                value.offer(temp);
                groupByGenre.put(temp.getGenre(), value);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(countByGenre.entrySet());
        Collections.sort(list, (f, s)-> -Integer.compare(f.getValue(), s.getValue()));

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> map : list) {
            Queue<Album> albums = groupByGenre.get(map.getKey());

            int count = 2;
            while (!albums.isEmpty()) {
                result.add(albums.poll().getUID());
                count--;

                if (count == 0) {
                    break;
                }
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    static class Album implements Comparable<Album>{
        private int UID;
        private String genre;
        private int play;

        public Album(int UID, String genre, int play){
            this.UID = UID;
            this.genre = genre;
            this.play = play;
        }

        public int getUID() {
            return UID;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        @Override
        public int compareTo(Album album) {
            if (this.play == album.getPlay()) {
                return Integer.compare(this.UID, album.getUID());
            }
            return Integer.compare(album.getPlay(), this.play);
        }

        @Override
        public String toString() {
            return "Album{" +
                    "UID=" + UID +
                    ", genre='" + genre + '\'' +
                    ", play=" + play +
                    '}';
        }
    }
}
