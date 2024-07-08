class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int[] container=new int[101];

        for(int num: nums){
            container[num]++;
        }

        for(int i=1;i<101;i++){
            container[i]+=container[i-1];
        }
        
        for(int i=0;i<n;i++){
            result[i]= nums[i] == 0 ? 0 : container[nums[i]-1];
        }
        return result;
    }
}

