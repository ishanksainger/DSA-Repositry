class Solution {
    public int[] productExceptSelf(int[] nums) {
           int sum=1;
        int[] output=new int[nums.length];
        output[0]=1;
        for(int i=1;i<nums.length;i++){
            sum*=nums[i-1];
            output[i]=sum;
        }
        int postfix=1;
        for (int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                output[i]*=postfix;
                continue;
            }
            postfix*=nums[i+1];
            output[i]=output[i]*postfix;
        }
        return output;
    }
}