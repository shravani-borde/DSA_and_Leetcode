class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList();

        if(n < 3)
            return result;
        
    
        Arrays.sort(nums); // sort

        for(int i = 0; i < n - 2; i++ )
        {
            int p1 = i+1; // pointeer 1
            int p2 = n - 1; // pointer 2
            if( i != 0 && nums[i] == nums[i-1] )    continue;
            int target = -nums[i];

            while(p1 < p2)
            {
                int sum = nums[p1] + nums[p2];
                if(sum == target)
                {
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                    p2--;
                    while(p1 < p2 && nums[p1] == nums[p1-1])    p1++;
                    while(p1 < p2 && nums[p2] == nums[p2+1])    p2--;
                }
                else if(sum < target)
                    p1++;
                else
                    p2--;
                
            }
        }
        return result;
    }
}