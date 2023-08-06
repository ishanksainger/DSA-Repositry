class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int prefix=0,postfix=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefix=0;
            }
    
            else{
            prefix+=nums[i-1];
            }
           postfix=sum-prefix-nums[i];
            if(prefix==postfix){
                return i;
            }
        }
        return -1;
    }
}