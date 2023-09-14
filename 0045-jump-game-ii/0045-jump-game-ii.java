class Solution {
    public int jump(int[] nums) {
        int farthest=0,jump=0,curr=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            //intution is we keep on calculating farthest but will only save it to curr or increase jump when we have complete i value till curr.
            //if first farthest is 4 and i is o and curr is 0 so we save farthest to curr. but untill i reaches curr again we will not save farthest in curr
            // so concept is we have to reach i till farthest in every turn to get max and once reaches we will save max farthest in curr and increase jump
            if(i==curr){
              curr=farthest;
              jump++;
            }
        }
        return jump;
    }
}