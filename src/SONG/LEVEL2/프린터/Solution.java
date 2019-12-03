package SONG.LEVEL2.프린터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {2,1,3,2}, 2));
		System.out.println(s.solution(new int[] {1,1,9,1,1,1}, 0));
	}
	
	public int solution(int[] priorities, int location) {
		ArrayList<Integer> answer = new ArrayList<>();
		Integer priorityOfLocation = priorities[location];
		
		
		//location에 해당되는 값보다 작은 요소들은 무조건 뒤로 가며 계산에 사용이 안되므로 필터링해줌
		LinkedList<Integer> queue = 
		IntStream.range(0, priorities.length)	// priorities 길이만큼 초기화된 IntStream 생성
			.boxed()								// int,long,double 요소를 Integer,Long,Double 요소로 박싱
			.filter(x -> priorityOfLocation <= priorities[x]) // location에 해당되는 값보다 크거나 같은 값들로 필터링 함
			.map(x -> x == location? Integer.MAX_VALUE : priorities[x]) // 요소가 location과 같으면 int 최대값, 아니면 priorites 값을 줌
			.collect(Collectors.toCollection(LinkedList::new));
		
		queue.forEach(item -> System.out.println("크거 같은 요소 = " + item));
		
		
		//location에 해당되는 값보다 큰 요소들을 필터링 해줌
		List<Integer> reversePriority = Arrays.stream(priorities)   // piorities 를 stream으로 바꿈
			.boxed()												// 박싱
			.filter(x -> priorityOfLocation < x)					// location에 해당되는 값보다 큰 애들로 필터링
			.sorted(Comparator.reverseOrder())						// 역정렬
			.collect(Collectors.toList());							// list로 컬렉
		
		reversePriority.forEach(item -> System.out.println("location 보다 큰 값 = " + item));
		
		for(Integer priority : reversePriority) {	//location 보다 큰 값들을 하나씩 가져옴
			while(queue.peek() != priority) {		//크거나 같은 요소들이 있는 queue와 큰요소와 다를경우 
				queue.offer(queue.pop());			//앞에서 뽑아서 뒤로 삽입(queue 특성)
			}
			answer.add(queue.poll());				// 큰 요소가 같아서 true가 되어 나오면 ArrayList에 하나씩 추가
		}
		//결과적으로 answer에는 뽑아져 나온 애들이 들어가게 된다.
		return answer.size() + queue.indexOf(Integer.MAX_VALUE)+1;
		// 추출한 갯수 + (location의 위치에 있는 값과 동일한 값을 가진 요소들만 남아있는 queue에서 순서를 구함(인덱스 값 0부터 시작하기에 +1을 해줌)
	}
}
