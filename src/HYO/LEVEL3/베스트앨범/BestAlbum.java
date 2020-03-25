package programmers.level3;

import java.util.*;

// Hash - 베스트 앨범
// Programmers Lv.3
public class BestAlbum {
    static class Album implements Comparable<Album> {
        int index;
        String genres;
        int plays;
        public Album(int index, String genres, int plays) {
            this.index = index;
            this.genres = genres;
            this.plays = plays;
        }

        @Override
        public int compareTo(Album o) {
            if( o.plays == this.plays )
                return this.index - o.index;
            return o.plays - this.plays;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int n = genres.length;

        // 1. 장르가 먼저 수록
        Map<String,Integer> genresMaps = new HashMap<>();
        Map<String,Integer> cntMaps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            genresMaps.put(genres[i], genresMaps.getOrDefault(genres[i], 0) + plays[i]);
            cntMaps.put(genres[i], cntMaps.getOrDefault(genres[i], 0) + 1);
        }

        // 1-1. cntMaps으로 answer size 구하는 로직
        int answerSize = 0;
        for( Map.Entry m : cntMaps.entrySet() ) {
            //System.out.println("genre: " + m.getKey() + ", cont:  " + m.getValue());
            answerSize += (int) m.getValue() >= 2 ? 2 : (int) m.getValue();
        }
        int[] answer = new int[answerSize];

        // 1-2. 장르별 총 재생 횟수 내림차순 정렬을 위한 로직
        ArrayList<Object[]> arrayForSort = new ArrayList<>();
        for( Map.Entry m : genresMaps.entrySet() ) {
            arrayForSort.add(new Object[]{m.getKey(), m.getValue()} );
        }
        arrayForSort.sort((o1, o2) -> (int) o2[1] - (int) o1[1]);

        // 2. 많이 재생된 노래 먼저 수록 -> PriorityQueue
        // 3. 장르 내 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록 -> PriorityQueue
        int answerIdx = 0;
        for( Object[] playlist : arrayForSort ) {
            PriorityQueue<Album> currGenre = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                if( playlist[0].equals(genres[i]) ) {
                    currGenre.add(new Album(i,genres[i],plays[i]));
                }
            }

            int count = 0;
            while( !currGenre.isEmpty() ) {
                if( count >= 2 ) break;
                if( answerIdx == answerSize ) break;

                Album album = currGenre.poll();
                answer[answerIdx++] = album.index;
                count ++;
                //System.out.println(album.index + " " + album.genres + " " + album.plays);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"}; int[] plays = {500, 600, 150, 800, 2500};
        //String[] genres = {"classic", "classic", "classic", "pop"}; int[] plays = {500, 150, 800, 2500};
        String[] genres = {"classic", "pop", "pop", "pop"}; int[] plays = {500, 1000, 300, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
