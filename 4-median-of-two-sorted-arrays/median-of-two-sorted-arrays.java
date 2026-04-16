class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int med = (n1 + n2) / 2;
        
        int i = 0;
        int j = 0;
        int prev = 0, ans = 0;

        for (int count = 0; count <= med; count++) 
        {
            prev = ans;
            if (i != n1 && j != n2) {
                if (nums1[i] > nums2[j])
                    ans = nums2[j++];
                else
                    ans = nums1[i++];
            }
            else if(i < n1)
                ans = nums1[i++];
            else
                ans = nums2[j++];
        }
        
        if((n1 + n2) % 2 == 1)
            return (double) ans;
        else
            return (double) (ans + prev)/2;
    }
}