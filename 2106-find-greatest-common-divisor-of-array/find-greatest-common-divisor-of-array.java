class Solution {
    public int findGCD(int[] nums) {
        if(nums == null)
            return 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        int small = nums[0];
        int large = nums[n];
        if(small == large)
            return small;
        
        int res = 1;
        for(int i = 2; i <= large; i++)
        {
            if(small % i == 0 & large % i == 0)
                res = i;
        }

        return res;
    }
}