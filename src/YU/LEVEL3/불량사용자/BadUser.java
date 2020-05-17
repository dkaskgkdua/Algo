// 45.5점

import java.util.Collection;
import java.util.HashMap;

class Solution {
    public int count = 0;
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[banned_id.length];
        dfs(user_id, banned_id, visited, 0);

		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < banned_id.length; i++) {
			hash.put(banned_id[i], hash.getOrDefault(banned_id[i], 0) + 1);
		}
		Collection<Integer> values = hash.values();
		for (Object value : values.toArray()) {
			if ((int) value > 0) {
				count /= (int) value;
			}
		}
		
        return count;
    }
    
    public void dfs(String[] user_id, String[] banned_id, boolean[] visited, int idx) {
        if (checkAll(visited)) {
            count++;
            return;
        }
        
        for (int i=idx; i<user_id.length; i++) {
            for (int j=0; j<banned_id.length; j++) {
                if (!visited[j] && isBannedID(user_id[i], banned_id[j])) {
                    visited[j] = true;
                    dfs(user_id, banned_id, visited, i+1);
                    visited[j] = false;
                }
            }
        }
    }

	public boolean isBannedID(String user_id, String banned_id) {
		if (banned_id.length() != user_id.length()) {
			return false;
		}
        
		for (int i = 0; i < banned_id.length(); i++) {
			if (banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i)) {
				return false;
			}
		}
		return true;
	}
        
	public boolean checkAll(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) return false;
		}
		return true;
	}
}