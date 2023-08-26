class Solution {
    public int findPeakElement(int[] nums) {
    List<Long> list = Arrays.stream(nums)
                       .mapToLong(value -> value)
                       .boxed()
                       .collect(Collectors.toList());
        list.add(0,Long.MIN_VALUE);
        list.add(Long.MIN_VALUE);
        if(nums.length<2){
            return 0;
        }
        int i=1;
        int j=nums.length;
        int result=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(list.get(mid)>list.get(mid-1) && list.get(mid)>list.get(mid+1)){
                result=mid;
                break;
            }
            else if(list.get(mid) > list.get(mid - 1) && list.get(mid) < list.get(mid + 1)){
                i=mid+1;
            }
               else{
                j=mid-1;
            }
        }
        return result-1;
    }
}