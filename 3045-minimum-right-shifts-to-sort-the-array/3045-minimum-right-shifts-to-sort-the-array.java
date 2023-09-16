class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n=nums.size();
        int count=0,ind=0;;
        for(int i=1;i<n;i++){
            if(nums.get(i-1)>nums.get(i)){
                ind=i;
                count++;
            }  
        }
        if(count>1) return -1;
        if(ind==0) return 0;
        
        return nums.get(n-1)>nums.get(0) ? -1:n-ind;
    }
}