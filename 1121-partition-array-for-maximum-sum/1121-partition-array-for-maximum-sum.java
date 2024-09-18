class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(0,arr,k,dp);
    }
    private int helper(int index, int[] arr, int k, int[]dp){
        int n=arr.length;
        if(index==n) return 0;
        if(dp[index]!=-1) return dp[index];
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        for(int i=index;i<Math.min(index+k,n);i++){
            len++;
            maxi=Math.max(maxi,arr[i]);
            int sum=len*maxi+helper(i+1,arr,k,dp);
            maxAns=Math.max(maxAns, sum);
        }
        return dp[index]=maxAns;

    }
}