class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][]dp=new int[n][m];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        return helper(dp,n-1,m-1,text1,text2);
    }
    public int helper(int[][]dp, int idx1, int idx2, String text1, String text2){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            return dp[idx1][idx2]= 1 + helper(dp,idx1-1,idx2-1,text1,text2);
        }
        return dp[idx1][idx2]= 0 + Math.max(helper(dp,idx1-1,idx2, text1,text2),helper(dp,idx1,idx2-1,text1,text2));
    }
}