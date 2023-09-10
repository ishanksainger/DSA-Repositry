class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);       
    }
    public void swap(int[] nums,int p1, int p2){
         for(int i=p1, j=p2;i<j;i++,j--){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}