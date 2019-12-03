package SONG.LEVEL2.멀쩡한사각형;

import java.math.BigInteger;

class Solution {
    		public static void main(String args[]) {
    			Solution s = new Solution();
    			System.out.println(s.solution(8, 12));
    		}
    	    public long solution(int w, int h) {
    	       BigInteger bw = new BigInteger(Integer.toString(w));
    	       BigInteger bh = new BigInteger(Integer.toString(h));
    	       
    	       BigInteger gcdInteger = bw.gcd(bh);
    	       long gcd1 = gcdInteger.longValue();
    	       long blockW = w/gcd1;
    	       long blockH = h/gcd1;
    	       
    	       long sum = w * h;
    	       
    	       return sum - gcd1*((blockW)+(blockH)-1);
    	    }
    	}