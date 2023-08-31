class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int buy=1;
        int[][]dp=new int[n+1][3];
        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    profit= Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }
                else{
                    profit= Math.max(prices[i]-fee + dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];
    }
}