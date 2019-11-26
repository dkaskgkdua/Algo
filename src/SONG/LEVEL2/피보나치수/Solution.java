package SONG.LEVEL2.피보나치수;

class Solution {
	  public int solution(int n) {
			return sol(n)%1234567;
			
		}
		public int sol(int n) {
			switch(n) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 1;
			default:
				return sol(n-1)+sol(n-2);
			}
		}
	}
