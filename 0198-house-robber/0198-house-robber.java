class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        return helper(nums, n);
    }
    public int helper(int[] nums, int n){
        
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int left=nums[i];
            if(i>1){
                left+=prev2;
            }
            int right=0+prev;
            int curr=Math.max(left, right);
            prev2=prev;
            prev=curr;
    }
    return prev;
    }
}