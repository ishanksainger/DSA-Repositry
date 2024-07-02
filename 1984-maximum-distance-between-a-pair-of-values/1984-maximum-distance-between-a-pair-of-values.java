class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=Integer.MIN_VALUE;
        int n=nums1.length;
        for(int i=0;i<n;i++){
            int j=binarySearch(nums2, i, nums1[i]);
            if(j!=-1){
                max=Math.max(max, j-i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    private int binarySearch(int[] nums2, int i, int target){
        int ans=-1;
        int lo=i, hi=nums2.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(nums2[mid]<target){
                hi=mid-1;
            }
            else{
                ans=mid;
                lo=mid+1;
            }
        }
        return ans;
    }
}
