package programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

// 카카오 코딩테스트 - 셔틀버스
// Programmers Lv.3
public class ShuttleBus{
    /**
     * 1) 버스 시간 끝에 탈 자리가 있는지?
     * 2) 없다면 대기 크루들 중 탈 수 있는 마지막 크루는 누군지?
     */

    static String busStartTime = "09:00";

    public static String solution(int n, int t, int m, String[] timetable) {
        ArrayList<Integer> crewTime = new ArrayList<>();
        for(String time : timetable) {
            crewTime.add(time2min(time));
        }
        crewTime.sort((t1,t2) -> t1-t2); // 오름차순 정렬

        int busTime = time2min(busStartTime);   // 버스 시간
        int lastCrew = crewTime.get(0);         // 마지막 탑승자
        int count = 0;
        while( n -- > 0 ) { // n번 셔틀버스 운행
            int s = busTime;
            List<Integer> temp = crewTime.stream().filter( x -> x <= s ).limit(m).collect(Collectors.toList());

            count = 0;
            for(Integer tempTime : temp) {
                crewTime.remove(tempTime);
                lastCrew = tempTime;
                count += 1;

            }

            busTime += t;
        }

        busTime -= t;
        //System.out.println("n: " + n + ", busTime: " + min2time(busTime) +", lastCrew: " + min2time(lastCrew));
        //System.out.println("count: " + count + ", m: " + m);

        // busTime: 버스 시간
        // lastCrew: 마지막 탑승 크루
        int ans = 0;
        if( lastCrew <= busTime && count == m ) {
            ans = lastCrew-1;
        } else {
            ans = busTime;
        }

        return min2time(ans);
    }

    private static int time2min(String time) {
        int hour = Integer.parseInt(time.split(":")[0]) * 60;
        int min = Integer.parseInt(time.split(":")[1]);

        return hour + min;
    }

    private static String min2time(int minute) {
        String hour = (minute/60) < 10 ? "0" + (minute/60) : String.valueOf(minute/60);
        String min = (minute%60) < 10 ? "0"+(minute%60) : String.valueOf(minute%60);

        return hour + ":" + min;
    }

    public static void main(String[] args) {
        //int n = 1; int t = 1; int m = 5; String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        //int n = 2; int t = 10; int m = 2; String[] timetable = {"09:10", "09:09", "08:00"};
        //int n = 2; int t = 1; int m = 2; String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
        //int n = 1; int t = 1; int m = 5; String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        //int n = 1; int t = 1; int m = 1; String[] timetable = {"23:59"};
        //int n = 10; int t = 60; int m = 45; String[] timetable = {"23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59"};
        //int n = 1; int t = 1; int m = 1; String[] timetable = {"09:00","23:59"};
        //int n = 1; int t = 1; int m = 1; String[] timetable = {"01:59"};
        //int n = 2; int t = 60; int m = 4; String[] timetable = {"08:59","08:59","08:59","09:00","23:59","23:59"};
        int n = 1; int t = 1; int m = 5; String[] timetable = {"00:00", "00:01", "00:02", "00:03","00:01"}; // 반례

        System.out.println(solution(n,t,m,timetable));
    }
}
