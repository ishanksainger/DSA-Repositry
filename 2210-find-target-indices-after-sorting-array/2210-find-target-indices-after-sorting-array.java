class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(target==nums[i]){
                list.add(i);
            }
        }
        return list;
    }
}