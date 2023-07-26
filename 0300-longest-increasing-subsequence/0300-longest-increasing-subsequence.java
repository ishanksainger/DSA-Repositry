class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        //n+1 for both because tabulation its opposite of memoization so we need 0 to n for both;
        int[][] dp=new int[n+1][n+1];
       /* no need of base case in tabulation as we are already has array of 0
        if(idx==nums.length){
            return 0;
        }
        */
        //in both we are starting from n-1 till 0 in index and till -1 for j as it is prev and in this as well we do plus 1 with j as we go
        // till -1 and there is no -1 in indexes so we add +1 so it maintains 0 indexing
        for(int i=n-1;i>-1;i--){
            for(int j=n-1;j>=-1;j--){
                int len= 0+ dp[i+1][j+1];
                if(j==-1 || nums[i]>nums[j]){
                len= Math.max(len, 1 + dp[i+1][i+1]);
                }
                dp[i][j+1]=len;
            }
        }
        
        return dp[0][0];
    }
}