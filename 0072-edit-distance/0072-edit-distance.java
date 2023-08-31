class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][]dp=new int[m][n];
        for(int[] nums: dp){
            Arrays.fill(nums,-1);
        }
        return helper(dp,word1,word2,m-1,n-1);
    }
    public int helper(int[][]dp, String word1, String word2, int index1, int index2){
        if(index1<0){
            return index2+1;
        }
        if(index2<0){
            return index1+1;
        }
        if(dp[index1][index2]!=-1){ 
            return dp[index1][index2];
        }
        if(word1.charAt(index1)==word2.charAt(index2)){
            dp[index1][index2]= 0+helper(dp, word1, word2, index1-1, index2-1);
        }
        else{
            dp[index1][index2]=Math.min( 1 + helper(dp, word1, word2, index1, index2-1),
            Math.min(1+helper(dp, word1, word2, index1-1, index2), 1 + helper(dp, word1, word2, index1-1, index2-1)));
        }
        return dp[index1][index2];
    }
}