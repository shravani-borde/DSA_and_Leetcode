class Solution {
    public void sol(int i, int n, String digits, List<String> res, StringBuilder combo, Map<Character, String> maps){
        if(i == n){
            res.add(combo.toString());
            return;
        }
        else{
            String letters = maps.get(digits.charAt(i));
            for(char ch: letters.toCharArray())
            {
                combo.append(ch);
                sol(i+1, n, digits, res, combo, maps);
                combo.deleteCharAt(combo.length() - 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String>  res = new ArrayList();

        if(digits == null || n == 0)
            return res;
        
        Map<Character, String> maps = new HashMap<>();
        maps.put('1',"");
        maps.put('2',"abc");
        maps.put('3',"def");
        maps.put('4',"ghi");
        maps.put('5',"jkl");
        maps.put('6',"mno");
        maps.put('7',"pqrs");
        maps.put('8',"tuv");
        maps.put('9',"wxyz");

        sol(0, n, digits, res, new StringBuilder(), maps);
        return res;
    }
}