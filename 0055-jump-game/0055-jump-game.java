class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int jump=0;
        for(int i=0;i<n;i++){
            if(i>jump) return false;
            jump=Math.max(jump,i+nums[i]);
        }
        return true;
    }
}