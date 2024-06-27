class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n=rewardValues.length;
        int[][]dp=new int[n][4001];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
        return getMax(0,0,n, rewardValues, dp);
    }
    public int getMax(int index, int currVal, int n, int[]arr, int[][]dp){
        if(index>=n){
            return currVal;
        }
        if(dp[index][currVal]!=-1){
            return dp[index][currVal];
        }
        int notTake=getMax(index+1, currVal, n, arr, dp);
        int take=0;
        if(arr[index]>currVal){
            take=getMax(index+1, currVal+arr[index], n, arr, dp);
        }
        return dp[index][currVal]=Math.max(take,notTake);
    }
}