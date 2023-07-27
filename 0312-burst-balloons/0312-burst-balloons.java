class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0,1);
        list.add(1);
        int[][] dp=new int[n+2][n+2];
        
        for(int i=n;i>0;i--){
            for(int j=1;j<=n;j++){
                if(i>j){
                    continue;
                }
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int ans=list.get(i-1) * list.get(k) * list.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    max=Math.max(max, ans);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
}