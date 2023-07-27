class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0,1);
        list.add(1);
        int[][] dp=new int[n+1][n+1];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        return helper(dp, 1, n, list);
    }
    public int helper(int[][]dp, int i, int j, List<Integer> list){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int ans=list.get(i-1) * list.get(k) * list.get(j+1) + helper(dp, i, k-1, list) + helper(dp, k+1, j, list);
            max=Math.max(max, ans);
        }
        return dp[i][j]=max;
    }
}