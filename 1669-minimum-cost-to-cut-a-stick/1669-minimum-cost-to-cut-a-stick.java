class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list=Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0,0);
        list.add(n);
        Collections.sort(list);
        int c=cuts.length;
        int[][] dp=new int[c+1][c+1];
        for(int[] nums: dp){
            Arrays.fill(nums, -1);
        }
        return helper(dp,list,1, c);
    }
    public int helper(int[][]dp, List<Integer> list, int i, int j){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int ans=list.get(j+1)-list.get(i-1) + helper(dp, list, i,k-1) + helper(dp, list, k+1, j);
            min=Math.min(min,ans);
        }
       return dp[i][j]=min;
    }
}