class Solution {
    public int maxProfit(int[] prices) {
        int buy=1;
        int k=2;
        int n=prices.length;
        int[][][]dp=new int[n][2][k+1];
        for(int[][] nums:dp){
            for(int[] num: nums){
                Arrays.fill(num,-1);
            }
        }
        return helper(dp,0,buy,k,prices);
    }
    public int helper(int[][][]dp, int idx, int buy, int k, int[] prices){
        if(idx==prices.length){
            return 0;
        }
        if(k==0){
            return 0;
        }

        if(dp[idx][buy][k]!=-1){
            return dp[idx][buy][k];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[idx] + helper(dp, idx+1,0,k,prices), 0+helper(dp, idx+1,1,k, prices));
        }
        else{
            profit=Math.max(prices[idx] + helper(dp, idx+1, 1, k-1, prices ), 0+helper(dp, idx+1,0, k, prices));
        }
        return dp[idx][buy][k]=profit;
    }
}