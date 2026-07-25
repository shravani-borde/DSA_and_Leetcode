class Solution {
    public int calPoints(String[] operations) {
        if(operations.length == 0 || operations == null)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("C")){
                if(st.size() != 0)
                    st.pop();
            }else if(operations[i].equals("D")){
                int j = st.peek();
                st.push((2 * j));
            }else if(operations[i].equals("+")){
                int top = st.pop();
                int res = st.peek() + top;
                st.push(top);
                st.push(res);
            }else{
                int j = Integer.valueOf(operations[i]);
                st.push(j);
            }
        }

        int ans = 0;
        while(st.size() != 0){
            ans += st.pop();
        }

        return ans;
    }
}