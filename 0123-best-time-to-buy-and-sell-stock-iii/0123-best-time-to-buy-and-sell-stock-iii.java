class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // we create 3d array because there is n transaction, and then buy 0 or 1 and cap of buying 2 at a time only
        // we are doing n+1 instead on n because in tabulation it will got i+1 from n-1 so it will go to n so to save out of bound we do n+1;
        int[][][] dp=new int[n+1][2][3];
        /* Dont need these base cases as in both the test cases if index is 0 then we run for loop on other 2 and then keep setting them 0
        but the dp array is already 0 no need to set them 0 again, we can ignore it
        for(int indx=0;indx<n;indx++){
            for(int buyy=0;buyy<=1;buyy++){
                dp[indx][buyy][0]=0;
            }
        }
        for(int buyy=0;buyy<=1;buyy++){
            for(int capp=0;capp<=2;capp++){
                dp[0][buyy][capp]=0;
            }
        }
        */
        // we are starting from back of n-1 as tabulation is opposite of memoization and rest buy and cap will start normally.
        // also cap 0 is already handled so starting cap 1 is we start.
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                     /* buy 1 means we will firstly buy the stock so we enter from if and see the condition
                        whenever we calculate profit we do profit= sell-buy. So buy is always negative.
                        So we do add it with negative value and then add it with recursive call which says move index with current buy 
                        stock and mark buy as 0 so we cant buy next and what if we skip this one so we add 0 and move to next index and 
                        mark buy as 1 as we need to buy this one*/
                        if(j==1){
                            // we keep the cap same because we are still buying and transactions only completes once we sell
                            dp[i][j][k]= Math.max(-prices[i] + dp[i+1][0][k], 0 + dp[i+1][1][k]);
                        }
                        /* so in this else condition we dont buy we sell, so as looked above sell is in positive format.
                        so we add pricess as positive with the recursive call which says i am selling the stock and ready to buy next one
                        and if we skipp and dont sell then add 0 and pass buy as 0 as we need to sell first */
                        else{
                            // in first we sell so we do cap-1 and in second we dont sell so transaction is still incomplete so cap same.
                            dp[i][j][k]=Math.max(prices[i] +dp[i+1][1][k-1], 0 + dp[i+1][0][k]);
                        }
                }
            }
        }
       
        // now we get max from both the recursive calls and it will update the profit variable and we put it in dp;
        return dp[0][1][2];
    }
}