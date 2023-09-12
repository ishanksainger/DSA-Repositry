class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,n,0,dp);
    }
    public boolean helper(int[]nums,int n, int index,int[]dp){
        if(index>=n-1){
            return true;
        }
        if(dp[index]!=-1){
            if(dp[index]==1){
                return true;
            }
            return false;
        }
        int maxJump = Math.min(index + nums[index], n - 1); // Calculate the maximum jump index.

        for(int i=index+1;i<=maxJump;i++){
           if(helper(nums,n,i,dp)){
               dp[i]=1;
               return true;
           }
        }
        dp[index]=0;
        return false;
    }
}