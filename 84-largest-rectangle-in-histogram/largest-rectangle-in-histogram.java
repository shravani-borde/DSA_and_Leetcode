class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if(n == 1)
            return heights[0];
        
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        //first, prev smallest element
        for(int i = 0; i < n; i++){
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        int max = 0;


        //then, next smaller element
        for(int i = n-1; i >= 0; i--){
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            
            int j = st.isEmpty() ? n : st.peek();
            max = Math.max(max, heights[i] * (j - pse[i] - 1) );
            st.push(i);
        }
        return max;
    }
}