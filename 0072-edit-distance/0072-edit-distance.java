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
        // this says if index1 exhaust and still there are word2 chars remain and it is 0 based index so we do index2+1 to tell that we need these opertions to do to match them lets says 3 inserts needs to be done to match
        if(index1<0){
            return index2+1;
        }
        // this says if index2 exhaust and still there are word1 chars remain and it is 0 based index so we do index1+1 to tell that we need these opertions to do to match them lets says 3 delete needs to be done to match
        if(index2<0){
            return index1+1;
        }
        if(dp[index1][index2]!=-1){ 
            return dp[index1][index2];
        }
        if(word1.charAt(index1)==word2.charAt(index2)){
            // here they already matched so nothing done so reduced both index
            dp[index1][index2]= 0+helper(dp, word1, word2, index1-1, index2-1);
        }
        else{
            // this is different operations
            //1. first operation is inserting, if we insert extra char in word 1 and if matches then i will be on same possition because char inserted on i+1, and j matches and reduces jo j-1.
            //2. second operation of deleting the character where char dont match so we delete from word1 so hence i-1
            //3 replace operation do replacement of word1 char with word2 char so it matches hence both -1, and obv get min and store 
            dp[index1][index2]=Math.min( 1 + helper(dp, word1, word2, index1, index2-1),
            Math.min(1+helper(dp, word1, word2, index1-1, index2), 1 + helper(dp, word1, word2, index1-1, index2-1)));
        }
        return dp[index1][index2];
    }
}