class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=Double.NEGATIVE_INFINITY,total=0;
        int i=0,j=0;
        int n=nums.length;
        while(j<n){
            total+=nums[j];
            if((j-i)+1==k){
                sum=Math.max(sum,total/k);
                total=total-nums[i];
                i++;
            }
            j++;
        }
        return sum;
    }
}