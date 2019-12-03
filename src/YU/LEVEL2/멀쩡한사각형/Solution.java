package kr.co.programmers.level2.lessons62048;
// 너비  * 높이 - (너비 + 높이 - 최소공약수)
class Solution {
	public long solution(long w, long h) {
		return w * h - (w + h - gcd(w, h));
	}
    long gcd(long x, long y) {
        if(y==0)    return x;
        else        return gcd(y, x%y);
    }
}