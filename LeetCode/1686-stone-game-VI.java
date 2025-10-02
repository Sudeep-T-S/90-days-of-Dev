class Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        int n = aliceValues.length;
        int[][] combined = new int[n][3];
        for (int i = 0; i < n; i++) {
            combined[i][0] = aliceValues[i] + bobValues[i];
            combined[i][1] = aliceValues[i];
            combined[i][2] = bobValues[i];
        }

        Arrays.sort(combined, (a, b) -> b[0] - a[0]);
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) 
                aliceScore += combined[i][1];
            else 
                bobScore += combined[i][2];
        }

        return Integer.compare(aliceScore, bobScore);
    }
}
