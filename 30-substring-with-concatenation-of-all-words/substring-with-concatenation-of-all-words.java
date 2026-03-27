class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return result;

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        int n = s.length();
        int wordLen = words[0].length();
        int totalWords = words.length;

        // We try all possible offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = i; right + wordLen <= n; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (counts.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // If too many occurrences, shrink window
                    while (window.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid window
                    if (count == totalWords) {
                        result.add(left);
                    }

                } else {
                    // Reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}