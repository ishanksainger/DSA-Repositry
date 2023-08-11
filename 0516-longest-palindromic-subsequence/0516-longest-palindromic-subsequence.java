class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
        return helper(dp,n-1,n-1,s,s1);
    }
    public int helper(int[][]dp, int idx1, int idx2, String s1, String s2){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1)==(s2.charAt(idx2))){
            return dp[idx1][idx2]=1+helper(dp,idx1-1,idx2-1, s1,s2);
        }
        return dp[idx1][idx2]=Math.max(helper(dp,idx1-1, idx2, s1,s2),helper(dp, idx1, idx2-1, s1,s2));
    }
}