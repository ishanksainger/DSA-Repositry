class Solution {
    public int numTilings(int n) {
        if(n==1) return n;
        if(n==2) return n;
        int mod=(int)(Math.pow(10,9)+7);
        int[]dp=new int[n+4];
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for(int i=4;i<=n;i++){
            dp[i]=((dp[i-1]*2)%mod + dp[i-3]%mod)%mod;
        }
        return dp[n];
    }
}