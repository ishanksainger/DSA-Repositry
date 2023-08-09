class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()];
        for(int[] list:dp){
            Arrays.fill(list, -1);
        }
        int min=Integer.MAX_VALUE;
        return min=Math.min(min,helper(triangle, 0,0, triangle.size(), dp));
    }
    public int helper(List<List<Integer>> triangle, int m, int n, int size, int[][] dp){
        if(m==size-1){
            return triangle.get(m).get(n);
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int left=helper(triangle,m+1,n,size,dp);
        int right=helper(triangle, m+1, n+1,size,dp);
        dp[m][n]=triangle.get(m).get(n)+ Math.min(left, right);
        return dp[m][n];
    }
}