class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        String[] arr = s.trim().split("\\s+");
        int n = arr.length - 1;
        String res = new String();
        while(n >= 0){
            res = res + arr[n] + " ";
            n--;
        }

        return res.trim();
    }
}