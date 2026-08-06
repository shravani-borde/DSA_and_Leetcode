class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if(n == 1)
            return heights[0];
        
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        //first, prev smallest element
        for(int i = 0; i < n; i++){
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        //then, next smaller element
        for(int i = n-1; i >= 0; i--){
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ansMax = 0;

        for(int i = 0; i < n; i++){
            int j = nse[i] - pse[i] - 1;
            ansMax = Math.max(ansMax, heights[i] * j );
        }

        return ansMax;
    }
}