// https://programmers.co.kr/learn/courses/30/lessons/42579

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genre_play = new HashMap<>();
        int len = genres.length;
        
        // 장르에 따른 총 재생 수 구하기
        for (int i = 0; i < len; i++) {
            if (genre_play.containsKey(genres[i])) {
                genre_play.put(genres[i], genre_play.get(genres[i]) + plays[i]);
            } else {
                genre_play.put(genres[i], plays[i]);
            }
        }

        // 재생 수에 대한 장르 정렬
        ArrayList<Genre> gerneList = new ArrayList<>();
        for (String key : genre_play.keySet()){
            Genre g = new Genre();
            g.name = key;
            g.play = genre_play.get(key);

            gerneList.add(g);
        }
        Collections.sort(gerneList);

        // 장르 내부에 순위
        while (gerneList.size() > 0) {
            Genre g = gerneList.get(0);
            gerneList.remove(0);

            ArrayList<Music> musicList = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                if (genres[i].equals(g.name)) {
                    Music m = new Music();
                    m.index = i;
                    m.play = plays[i];

                    musicList.add(m);
                }
            }
            // play에 따른 내림차순 정렬
            Collections.sort(musicList);

            // 인기 곡 2개 꺼내기
            answer.add(musicList.get(0).index);
            musicList.remove(0);
            if (musicList.size() > 0) {
                answer.add(musicList.get(0).index);
                musicList.remove(0);
            }
        }
        =
        return toIntArray(answer);
    }
    
    int[] toIntArray(ArrayList<Integer> list) {
        int[] intArr = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
           intArr[i] = Integer.parseInt(list.get(i).toString());
        }
        
        return intArr;
    }

    static class Genre implements Comparable<Genre> {
        String name;
        int play;

        @Override
        public int compareTo(Genre o) {
            return o.play - this.play;
        }

        @Override
        public String toString() {
            return "[" + name + ", " + play + "]";
        }
    }

    static class Music implements Comparable<Music> {
        int index;
        int play;

        @Override
        public int compareTo(Music o) {
            return o.play - this.play;
        }

        @Override
        public String toString() {
            return "[" + index + ", " + play + "]";
        }
    }
}