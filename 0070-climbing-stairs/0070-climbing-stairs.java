class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        if(n==1){
            return n;
        }
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            int num=dp[i-1];
            int num1=dp[i-2];
            dp[i]=num+num1;
        }
        return dp[n];
    }
}