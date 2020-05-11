// https://programmers.co.kr/learn/courses/30/lessons/43237

import java.util.Arrays;

class Budget {
    public int budget(int[] budgets, int M) {
        Arrays.sort(budgets);
        
        int l = 1;
        int r = budgets[budgets.length - 1];
        int m;

        while (l <= r) {
            m = l + (r-l)/2;

            if (M < checkBudget(budgets, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
    
    int checkBudget(int[] budgets, int m) {
        int total = 0;
        for (int i = 0; i < budgets.length; i++) {
            total += (budgets[i] >= m)? m : budgets[i];
        }
        return total;
    }
}