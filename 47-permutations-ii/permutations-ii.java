class Solution {
    Set<List<Integer>> hashSet = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, res, 0);
        return res;
    }

    public void backTrack(int[] nums, List<List<Integer>> res, int i)
    {
        if(i == nums.length)
        {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums)    temp.add(num);
            if(!hashSet.contains(temp))
            {
                res.add(temp);
                hashSet.add(temp);
            }
        }

        for(int j = i; j < nums.length; j++)
        {
            swap(nums, i, j);
            backTrack(nums, res, i+1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}