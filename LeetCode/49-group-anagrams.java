class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
