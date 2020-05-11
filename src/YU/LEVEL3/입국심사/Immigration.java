import java.util.Arrays;

class Immigration {
	public long immigration(int n, int[] times) {
		Arrays.sort(times);

		long l = 1;
		long r = (long) times[times.length - 1] * (long) n;
		long m;

		while (l <= r) {
			m = l + (r - l) / 2;

			if (n <= checkNum(times, m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return l;
	}

	long checkNum(int[] times, long m) {
		long total = 0;
		for (int time : times) {
			total += m / time;
		}
		return total;
	}
}