class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), new HashSet<>(), nums);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> tempList, Set<Integer> tempSet, int[] nums)
    {
        if(tempSet.size() == nums.length)
        {
            res.add(new ArrayList<>(new ArrayList<>(tempList)));
            return;
        }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(tempSet.contains(nums[i]))   continue;

                tempSet.add(nums[i]);
                tempList.add(nums[i]);

                backTrack(res, tempList, tempSet, nums);

                tempSet.remove(tempList.get( tempList.size() - 1) );
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}