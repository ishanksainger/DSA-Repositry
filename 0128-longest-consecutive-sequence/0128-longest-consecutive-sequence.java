class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max=0;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i]-1)){
              int currNum=nums[i];
              int count=0;
            while(set.contains(currNum++)){
              count++;
            } 
            max=Math.max(max,count);
            if(max>n/2) break;
           }
        }
        return max;
    }
}