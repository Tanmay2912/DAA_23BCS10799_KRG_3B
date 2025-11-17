class Solution {
    public int monkeyMove(int n) {
        if(n == 1 || n == 0) {
            return 0;
        }
        long res = 1, base = 2, mod = (long)(1e9+7);
        while(n != 0) {
            if(n % 2 == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            n = n >> 1;
        }
        return (int)((res - 2 + mod) % mod);
    }
}
