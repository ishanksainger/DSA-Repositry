class Solution {
    public int removeDuplicates(int[] nums) {
        // first if i==j then increase j and check again
        // if i and j dont matches then increase both
        // if i and j matches and more than 2 times then turn j into -1 and and increase j and if they dont matches then put i at j-1;

        int i=0,j=1;
        int n=nums.length;
        while(j<n){
            int x=nums[i];
            int y=nums[j];
            if(x==y && j-i+1>2){
                nums[j]=-100;
                j++;
            }
            else if(x==y && j-i+1==2){
                j++;
            }
            else{
               i=j;
               j++;
            }
        }
        int index=0;
        for(int k=0;k<n;k++){
            if(nums[k]!=-100){
                nums[index]=nums[k];
                index++;
            }
        }
        return index;
    }
}