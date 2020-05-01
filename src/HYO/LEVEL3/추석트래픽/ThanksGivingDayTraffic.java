package programmers.level3;

import java.util.*;

public class ThanksGivingDayTraffic {
    // 단위 : milisec
    private static int parseEndTime(String time) {
        String[] split = time.split(":");

        int hour = 60 * 60 * 1000 * Integer.parseInt(split[0]);
        int min  = 60 * 1000 * Integer.parseInt(split[1]);
        int sec  = (int) (1000 * Double.parseDouble(split[2]));
        //System.out.println(split[0] +" " + split[1] + " " + split[2]);
        //System.out.println(hour + " " + min + " " + sec);

        return hour + min + sec;
    }

    private static int parseTime(String seconds) {
        // System.out.println((int) (Double.parseDouble(seconds.split("s")[0]) * 1000));

        return (int) (Double.parseDouble(seconds.split("s")[0]) * 1000);
    }

    public static int solution(String[] lines) {

        ArrayList<Traffic> list = new ArrayList<Traffic>();
        for(String line : lines) {
            int e = parseEndTime(line.split(" ")[1]);
            int t = parseTime(line.split(" ")[2]);

            list.add(new Traffic(e-t+1, e));
        }

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;

            for (int j = i; j < list.size(); j++) {
                if( list.get(i).e + 999 >= list.get(j).s ) {
                    count ++;
                    //System.out.println("session: " + session + ", start: " + list.get(j).s + " " + (list.get(j).s - session));
                }
            }
            answer = Math.max(answer,count);
        }

        return answer;
    }

    static class Traffic {
        int s;
        int e;
        public Traffic(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        //String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        //String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};

        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        System.out.println(solution(lines));
    }
}
