class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0,j=n-1;
        int count=0;
        while(i<j){
            int num=nums[i]+nums[j];
            if(num<k){
                i++;
            }
            else if(num>k){
                j--;
            }
            else{
                i++;
                j--;
                count++;
            }
        }
        return count;
    }
}