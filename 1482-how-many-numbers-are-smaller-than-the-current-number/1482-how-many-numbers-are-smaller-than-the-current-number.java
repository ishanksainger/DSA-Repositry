class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        List<Integer> list=new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        Collections.sort(list);

        for(int i=0;i<n;i++){
            int x=list.indexOf(nums[i]);
            result[i]=x;
        }
        return result;
    }
}