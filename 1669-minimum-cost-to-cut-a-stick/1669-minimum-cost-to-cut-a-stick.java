class Solution {
    public int minCost(int n, int[] cuts) {
        int size=cuts.length;
        List<Integer> list=Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0,0);
        list.add(n);
        Collections.sort(list);
        int[][] dp=new int[size+1][size+1];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
        return helper(1,size,dp, list);
    }
    public int helper(int start,int n, int[][] dp, List<Integer> list){
        if(start>n){
            return 0;
        }
        if(dp[start][n]!=-1){
            return dp[start][n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=start;i<=n;i++){
            min=Math.min(min, list.get(n+1)-list.get(start-1) + helper(start,i-1,dp,list)+ helper(i+1,n,dp,list) );
        }
        return dp[start][n]=min;
    }
}