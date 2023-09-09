class Solution {
    public int majorityElement(int[] nums) {
        int count=1,element=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]!=element && count>0){
                count--;
                if(count==0){
                    continue;
                }
            }
            if(count==0){
                element=nums[i];
                count++;
            }
            else if(element==nums[i]){
                count++;
            }
        }
        return element;
    }
}