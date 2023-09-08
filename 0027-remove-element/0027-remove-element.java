class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(val==nums[i]){
                count++;
                nums[i]=-100;
            }
        }
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.removeAll(java.util.Collections.singleton(-100));
        int size=list.size();
        for(int i=0;i<count;i++){
            list.add(-100);
        }
        for(int i=0;i<n;i++){
            nums[i]=list.get(i);
        }
        return size;
    }
}