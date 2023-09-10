class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0,temp=0,count=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[j]){
            temp=nums[i];
            nums[i]=nums[j+1];
            nums[j+1]=temp;
            j++;
            count++;
            }
        }
        return count;
    }
}
       