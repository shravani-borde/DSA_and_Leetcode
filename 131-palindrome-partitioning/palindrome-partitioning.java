class Solution {
    List<List<String>> res = new ArrayList();

    public void backdrop(int i, int n, String s, List<String> path){
        if(i == n){
            res.add(new ArrayList<>(path));
            return;
        }
        else{
            for(int end = i; end < n; end++)
            {
                if(isPalin(i, end, s)){
                    path.add(s.substring(i,end+1));
                    backdrop(end+1, n, s, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public boolean isPalin(int i, int j, String s)
    {
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        if(s == null || n == 0)
            return res;
        
        backdrop(0, n, s, new ArrayList<>());
        return res;
    }
}