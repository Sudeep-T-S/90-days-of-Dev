class Solution {

    public boolean checkRecord(String s) {

        int countA = 0, countL = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == 'A') {

                countA++;
                if (countA > 1) 
                    return false;

                countL = 0;
            } else if (c == 'L') {

                countL++;
                if (countL > 2) 
                    return false;

            } else 
                countL = 0; 
        }

        return true;
    }
}
