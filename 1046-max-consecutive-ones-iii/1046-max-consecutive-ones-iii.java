class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int zeros=0,max=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<n){
            if(nums[j]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[i]==0){
                    zeros--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}