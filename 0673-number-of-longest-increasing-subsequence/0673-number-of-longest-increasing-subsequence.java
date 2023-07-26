class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        // we are filling it with 1 because all the numbers is already counted and len is already 1 
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[i]>nums[j] && dp[j]==dp[i]){
                    count[i]=count[j];
                    dp[i]=dp[j]+1;
                }
                else if(nums[i]>nums[j] && dp[j]+1==dp[i]){
                    count[i]+=count[j];
                }
            }
            max=Math.max(dp[i],max);
        }
        int num=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max){
                num+=count[i];
            }
        }
        return num;
    }
}