class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) 
            return "";
        
        int n = s.length();
        int max_length = 0;
        String res = "";

        for (int start = 0; start < n; start++) {
            for (int end = n; end > start; end--) {
                if (end - start <= max_length) {
                    break; 
                }
                
                if (isPalindrome(s, start, end - 1)) {
                    max_length = end - start;
                    res = s.substring(start, end);
                    break;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false; 
            }
        }
        return true;
    }
}