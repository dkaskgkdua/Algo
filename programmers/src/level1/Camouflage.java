package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camouflage {
	public static Map<String, String> hmClothes = new HashMap<String, String>();
	public static boolean[] visited;
	public static String[] clothesName;
	public static List<String> psClothes = new ArrayList<String>();
	public static int cnt = 0, result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
			{ "green_turban", "headgear" } }));
		
		
		result=0;
		System.out.println(solution(new String[][] { { "crow_mask", "face" }, { "blue_sunglasses", "face" },
			{ "smoky_makeup", "face" } }));
		

	}

	public static int solution(String[][] clothes) {

		clothesName = new String[clothes.length];
		visited = new boolean[clothes.length];
		for (int i = 0; i < clothes.length; i++) {
			hmClothes.put(clothes[i][0], clothes[i][1]);
			clothesName[i] = clothes[i][0];
		}
		powerSet(clothes.length, 0);
		return result;
	}

	public static void powerSet(int n, int dep) {

		if (n == dep) {
			int i;

			for (i = 0; i < n; i++) {
				if (visited[i] == true) {
					// System.out.print(clothesName[i]+", ");
					psClothes.add(hmClothes.get(clothesName[i]));
				}

			}
			
		
			for (int j = 0; j < psClothes.size(); j++) {
				List<String> copy=new ArrayList<String>(psClothes);
				if(copy.size()==1) {
					result++;
					System.out.println("1");
					break;
				}
				copy.remove(j);
				
				if (copy.contains(psClothes.get(j))) {
					//System.out.println(psClothes.get(j));
					 break;
					
				} 
				else cnt++;
				
		
			}
			if(cnt==psClothes.size()) {
				System.out.println("2");
				result++;
			}
			
			psClothes.clear();
			
			return;

		}
		visited[dep] = true;
		powerSet(n, dep + 1);
		visited[dep] = false;
		powerSet(n, dep + 1);

	}
}
