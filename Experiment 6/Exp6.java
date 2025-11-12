package DAA;

public class Exp6 {
    public static boolean subsetSumOptimized(int[] arr, int S) {
        boolean[] dp = new boolean[S + 1];
        dp[0] = true; 
        for (int num : arr) {
            for (int j = S; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[S];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int S = 9;
        System.out.println(subsetSumOptimized(arr, S));
    }
}
