class Solution {
    public int searchInsert(int[] nums, int target) {

        int l, h, mid;
        l = 0;
        mid = 0;
        h = nums.length - 1;

        while(l <= h)
        {
            mid = l + (h - l)/2;

            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid] < target)
                l = mid + 1;
            
            else
                h = mid-1;
        }

        if(nums[mid] <= target)
            return mid + 1;
        else return mid;

    }
}