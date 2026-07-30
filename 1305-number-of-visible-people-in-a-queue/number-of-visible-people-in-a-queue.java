class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ans[n-1] = 0;

        Stack<Integer> st = new Stack<>();
        st.push(heights[n-1]);

        for(int i = n-2; i >= 0; i--){
            int count = 0;
            while(st.size() != 0 && heights[i] > st.peek()){
                st.pop();
                count++;
            }
            if(st.size() != 0 && st.peek() > heights[i])  count++;
            st.push(heights[i]);
            ans[i] = count;
        }
        return ans;
    }
}