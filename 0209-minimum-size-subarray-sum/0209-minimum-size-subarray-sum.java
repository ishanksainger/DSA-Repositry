class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        int sum=0,min=Integer.MAX_VALUE;
        while(j<n){
            sum+=nums[j];
            if(sum>=target){
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                sum-=nums[j];
                i++;
            }
            else{
                j++;
            }
            
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}