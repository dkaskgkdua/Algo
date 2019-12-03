package SONG.LEVEL2.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int[] c = s.solution(new int[] {40, 93 ,30, 55, 60, 65}, new int[] {60, 1, 30, 5, 10, 7});
		Arrays.stream(c).forEach(item -> System.out.println(item));
	}
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> pro = new ArrayList<Integer>();
        List<Integer> speed = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int progress : progresses) {
        	pro.add(progress);
        }
        for(int speedss : speeds) {
        	speed.add(speedss);
        }
        while(true) {
        	int count = 0;
        	for(int i =0; i < pro.size(); i++) { // 각 항목별 speed를 더해줌
        		pro.set(i, pro.get(i) + speed.get(i));
        	}
        	for(int i = 0; i < pro.size(); i++) {  // 100점 넘는지 확인하는 구간
        		if(pro.get(i) >= 100) {// 앞에서부터 100점 이상인지 확인
        			count++;	    //100점 이상일시 배포
        			pro.remove(i);  //배포 후 제거
        			speed.remove(i--);
        			if(pro.size()== 0) {answer.add(count);}
        		} else {		
        			if(count != 0) {	//count 0이 아닐경우 배포숫자 더함
        				answer.add(count);
        			}
        			break;		// 100점 미만이면 for문 빠져나옴
        		}
        	}
        	if(pro.size() <= 0) {
        		break;
        	}
        }
        int[] ans = new int[answer.size()];
        for(int i =0; i < answer.size(); i++) {
        	ans[i] = answer.get(i);
        }
        
        return ans;
    }
}