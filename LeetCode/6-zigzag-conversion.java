class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] ans = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            ans[i] = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            
            for (int idx = 0; idx < numRows && i < s.length(); idx++)
                ans[idx].append(s.charAt(i++));

            for (int idx = numRows - 2; idx > 0 && i < s.length(); idx--)
                ans[idx].append(s.charAt(i++));
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder str : ans)
            res.append(str);

        return res.toString();
    }
}
