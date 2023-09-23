class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=numbers.length;
        for(int i=0;i<n;i++){
            int value=target-numbers[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return null;
    }
}