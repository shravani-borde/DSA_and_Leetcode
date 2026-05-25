import java.util.*;

class Solution {

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // convert numbers to strings
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }

        // custom sorting
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // if all are zeros
        if(arr[0].equals("0")) {
            return "0";
        }

        String ans = "";

        // join all strings
        for(String s : arr) {
            ans += s;
        }

        return ans;
    }
}