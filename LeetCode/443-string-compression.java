class Solution {

    public int compress(char[] chars) {

        int n = chars.length;
        int write = 0, read = 0;

        while (read < n) {

            int start = read;
            while (read < n && chars[read] == chars[start]) 
                read++;

            chars[write++] = chars[start];
            int count = read - start;
            if (count > 1) {

                for (char c : String.valueOf(count).toCharArray()) 
                    chars[write++] = c;
            }
        }
        
        return write;
    }
}
