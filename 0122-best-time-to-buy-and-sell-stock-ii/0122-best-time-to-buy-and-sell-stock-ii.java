class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
        int[][] dp=new int[n][2];
        for(int[] nums: dp){
            Arrays.fill(nums, -1);
        }
        return helper(0 ,dp, prices, buy);
    }
    public int helper(int index, int[][] dp, int[] prices, int buy ){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        /* buy 1 means we will firstly buy the stock so we enter from if and see the condition
        whenever we calculate profit we do profit= sell-buy. So buy is always negative.
        So we do add it with negative value and then add it with recursive call which says move index with current buy 
        stock and mark buy as 0 so we cant buy next and what if we skip this one so we add 0 and move to next index and 
        mark buy as 1 as we need to buy this one*/
        if(buy==1){
            profit= Math.max(-prices[index] + helper(index+1, dp, prices ,0), 0 + helper(index+1, dp, prices, 1));
        }
        /* so in this else condition we dont buy we sell, so as looked above sell is in positive format.
        so we add pricess as positive with the recursive call which says i am selling the stock and ready to buy next one
        and if we skipp and dont sell then add 0 and pass buy as 0 as we need to sell first */
        else{
            profit=Math.max(prices[index] + helper(index+1, dp, prices, 1), 0 + helper(index+1, dp, prices, 0));
        }
        // now we get max from both the recursive calls and it will update the profit variable and we put it in dp;
        return dp[index][buy]=profit;
    }
}