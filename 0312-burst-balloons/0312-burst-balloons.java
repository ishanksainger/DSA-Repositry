class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0,1);
        list.add(1);
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
        return helper(dp,1,n,list);
    }
    public int helper(int[][]dp, int idx1, int idx2, List<Integer> list){
        if(idx1>idx2){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int max=0;
        for(int i=idx1;i<=idx2;i++){
            max=Integer.max(max, list.get(idx1-1) * list.get(i) * list.get(idx2+1) + helper(dp, idx1,i-1,list)+helper(dp, i+1,idx2, list));
        }
        return dp[idx1][idx2]=max;
    }
}