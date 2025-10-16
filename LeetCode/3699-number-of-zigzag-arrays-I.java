class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int range = r - l + 1;
        int[] dpUp = new int[range];
        int[] dpDn = new int[range];
        for (int v = 0; v < range; v++) {
            dpUp[v] = 1;
            dpDn[v] = 1;
        }

        for (int pos = n - 2; pos >= 0; pos--) {

            int[] prefixDn = new int[range + 1];
            for (int v = range - 1; v >= 0; v--) 
                prefixDn[v] = (dpDn[v] + prefixDn[v + 1]) % MOD;

            int[] nextUp = new int[range];
            for (int v = 0; v < range; v++) 
                nextUp[v] = (v < range - 1) ? prefixDn[v + 1] : 0;

            int[] prefixUp = new int[range + 1];
            for (int v = 1; v <= range; v++) 
                prefixUp[v] = (prefixUp[v - 1] + dpUp[v - 1]) % MOD;

            int[] nextDn = new int[range];
            for (int v = 0; v < range; v++) 
                nextDn[v] = prefixUp[v];

            dpUp = nextUp;
            dpDn = nextDn;
        }

        int result = 0;
        for (int v = 0; v < range; v++) {
            result = (result + dpUp[v]) % MOD;
            result = (result + dpDn[v]) % MOD;
        }
        
        return result;
    }
}
