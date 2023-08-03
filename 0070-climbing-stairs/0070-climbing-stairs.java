class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
    public int helper(int[]dp, int idx){
        if(idx==1){
            return 1;
        }
        if(idx==2){
            return 2;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int step1=helper(dp, idx-1);
        int step2=helper(dp, idx-2);
        return dp[idx]=step1+step2;
    }
}