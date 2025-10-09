class Solution {

    public int distinctSubseqII(String s) {

        final int MOD = 1_000_000_007;
        long[] endsIn = new long[26];
        for (char c : s.toCharArray())
            endsIn[c - 'a'] = (Arrays.stream(endsIn).sum() + 1) % MOD;
            
        return (int)(Arrays.stream(endsIn).sum() % MOD);
    }
}
