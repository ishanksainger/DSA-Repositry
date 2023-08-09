class Solution {
    int max;
    public int minFallingPathSum(int[][] matrix) {
        max=Integer.MAX_VALUE;
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    int upLeft =Integer.MAX_VALUE, upRight=Integer.MAX_VALUE;
                    if(j-1>=0){
                        upLeft=dp[i-1][j-1];
                    }
                    
                    if(j+1<n){
                        upRight=dp[i-1][j+1];
                    }
                    int up=dp[i-1][j];
                    dp[i][j]=matrix[i][j]+ Math.min(upLeft,Math.min(upRight,up));
                }
            }
        }
        int max=Integer.MAX_VALUE;
        for(int j=0; j<n;j++){
            max = Math.min(max,dp[n-1][j]);
        }
        return max;
    }
}