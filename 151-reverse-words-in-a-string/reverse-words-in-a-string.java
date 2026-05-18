class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        String[] arr = s.split("\\s+");
        int n = arr.length - 1;
        StringBuilder res = new StringBuilder();
        res.append(arr[n]);
            n--;
        while(n >= 0){
            res.append(" " + arr[n]);
            n--;
        }

        return res.toString().trim();
    }
}