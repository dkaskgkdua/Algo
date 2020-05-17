// 실패

class Solution {
    boolean[] check = new boolean[1_000_000_000];
    
    public int solution(int[] weight) {
        boolean[] visited = new boolean[weight.length];
        getSet(weight, 0, visited, weight.length);
        
        for (int i = 1; i < 1_000_000_000; i++) {
            if (!check[i]) return i;
        }
        return 1_000_000_000;
    }

    public void getSet(int[] arr, int index, boolean[] visited, int leng) {
        if (index == leng) {
            check[sum(arr, visited, leng)] = true;
            return;
        }

        visited[index] = false;
        getSet(arr, index + 1, visited, leng);
        visited[index] = true;
        getSet(arr, index + 1, visited, leng);

    }

    public int sum(int[] arr, boolean[] visited, int leng) {
        int sum = 0;
        for (int i = 0; i < leng; i++){
            if (visited[i]) sum += arr[i];
        }
        return sum;
    }
}