class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        for(int num: nums){
            sum+=num;
        }
        int finalTarget=(sum-target)/2;
        if(finalTarget<0 || (sum-target)%2!=0){
            return 0;
        }
        int[][] dp=new int[n][finalTarget+1];
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(nums[0]!=0 && nums[0]<=finalTarget){
            dp[0][nums[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<finalTarget+1;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=notTake+take;
            }
        }
        return dp[n-1][finalTarget];
    }
}
