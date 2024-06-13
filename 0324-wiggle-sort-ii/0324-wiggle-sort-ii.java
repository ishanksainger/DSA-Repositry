class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int actualLen=nums.length-1;
        int[] copyNums=Arrays.copyOf(nums,n);
        Arrays.sort(copyNums);
        for(int i=1;i<n;i+=2){
            nums[i]=copyNums[actualLen--];
        }
        for(int i=0;i<n;i+=2){
            nums[i]=copyNums[actualLen--];
        }
    }
}