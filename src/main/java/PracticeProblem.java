import java.util.*;

public class PracticeProblem {

    private static Map<Integer, Integer> fibHash = new HashMap<>();

    public static int fib(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;

        if (fibHash.containsKey(num)) return fibHash.get(num);

        int result = fib(num - 1) + fib(num - 2);
        fibHash.put(num, result);
        return result;
    }
    private static Map<Integer, Integer> costCache = new HashMap<>();

    public static int minCostClimbingStairs(int[] cost) {
        costCache.clear();  // Reset cache in case reused
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private static int minCost(int[] cost, int i) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];

        if (costCache.containsKey(i)) return costCache.get(i);

        int result = cost[i] + Math.min(minCost(cost, i - 1), minCost(cost, i - 2));
        costCache.put(i, result);
        return result;
    }


    public static void main(String[] args) {
	}
}
