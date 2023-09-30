class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            if(mp.getValue()==1){
                return -1;
            }
            else if(mp.getValue()==2 || mp.getValue()==3){
                count++;
            }
            else{
                if(mp.getValue() % 3==0){
                    count+=mp.getValue()/3;
                }
                else{
                    int num=mp.getValue()%3;
                    if(num%2==0) count+=num/2+(mp.getValue()/3);
                    else count+=mp.getValue()/3+num;
                }
            }
        }
        return count;
    }
}