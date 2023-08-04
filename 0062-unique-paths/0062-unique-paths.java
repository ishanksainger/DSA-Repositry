class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                    continue;
                }
                int move=0,notMove=0;
                if(i>0){
                    move=dp[i-1][j];
                }
                if(j>0){
                    notMove=dp[i][j-1];
                }
                dp[i][j]=move+notMove;
            }
        }
        return dp[m-1][n-1];
    }
}