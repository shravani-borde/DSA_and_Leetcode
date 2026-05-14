class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();

        for(String s : strs)
        {
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);
            if(!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
        }
}