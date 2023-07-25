class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,totalSum=0;
        for(int i=1;i<=nums.length;i++){
            sum+=i;
        }
         for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        return sum-totalSum;
    }
}