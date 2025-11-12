package DAA;

public class Exp7 {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
