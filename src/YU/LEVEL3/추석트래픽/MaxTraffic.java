// https://programmers.co.kr/learn/courses/30/lessons/17676

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

class MaxTraffic {
	public int maxTraffic(String[] lines) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		int leng = lines.length;
		Long[] startTime = new Long[leng];
		Long[] endTime = new Long[leng];
		int max = 1;
		
		for (int i = 0; i < leng; i++) {
			String datetime = lines[i].substring(0, 23);
			int millisec = (int) (Float.valueOf(lines[i].substring(24, lines[i].length() - 1)) * 1000);
						
			endTime[i] = toLong(datetime, formatter);
			startTime[i] = addMiili(endTime[i], 1 - millisec);
		}
		
		for (int i = 0; i < leng; i++) {
			int tmpMax = 0;
			for (int j = 0; j < leng; j++) {
				if (startTime[i] - endTime[j] > 1000) {
					continue;
				}

				if(((endTime[i] - startTime[j]) <= 0 && (startTime[j] - endTime[i]) < 1000)
                    || ((endTime[i] - endTime[j]) <= 0 && (endTime[j] - endTime[i]) < 1000)
                    || ((endTime[i] - startTime[j]) > 0 && (endTime[i] - endTime[j]) <= 0)) {
					tmpMax++;
	            }
			}
			
			if (max < tmpMax) {
				max = tmpMax;
			}
		}

		return max;
	}

	public static Long toLong(String str_date, SimpleDateFormat formatter) {
		try {
			return formatter.parse(str_date).getTime();
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}
	
	public static Long addMiili(Long date, int milli) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		cal.add(Calendar.MILLISECOND, milli);
		return cal.getTime().getTime();
	}
}