class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        // we are filling it with 1 because all the numbers is already counted and len is already 1 
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max=0;
        // we are starting from 0 to n-1 for both the array
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                //in this we will check if the future i is bigger than prev j and also if dp len of i and j is equal or not
                if(nums[i]>nums[j] && dp[j]==dp[i]){
                    // if yes then we copy the count and increase the len for future dp i.e i because that is a subsequence
                    count[i]=count[j];
                    dp[i]=dp[j]+1;
                }
                // if prev j is smaller thann future i i.e dp len of i is bigger than j then we will not increase the len we just increase 
                // count because of the same len we have got more numbers.
                else if(nums[i]>nums[j] && dp[j]+1==dp[i]){
                    count[i]+=count[j];
                }
            }
            max=Math.max(dp[i],max);
        }
        // after getting max we will get the total number of same max number in dp array and count all their sum and return.
        int num=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max){
                num+=count[i];
            }
        }
        return num;
    }
}