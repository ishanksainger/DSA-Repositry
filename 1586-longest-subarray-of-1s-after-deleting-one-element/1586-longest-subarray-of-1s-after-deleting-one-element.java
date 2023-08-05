class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int zeros=0,k=1;
        int max=Integer.MIN_VALUE;
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
            max=Math.max(max,(j-i+1)-k);
            j++;
        }
        if(zeros==0){
            return nums.length-1;
        }
        return max;
    }
}