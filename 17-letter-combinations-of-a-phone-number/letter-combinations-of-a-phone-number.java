class Solution {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void sol(int i, int n, String digits, List<String> res, StringBuilder combo){
        if(i == n){
            res.add(combo.toString());
            return;
        }
        else{
            String letters = MAPPING[digits.charAt(i) - '0'];
            for(char ch: letters.toCharArray())
            {
                combo.append(ch);
                sol(i+1, n, digits, res, combo);
                combo.deleteCharAt(combo.length() - 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String>  res = new ArrayList();

        if(digits == null || n == 0)
            return res;
        
        sol(0, n, digits, res, new StringBuilder());
        return res;
    }
}