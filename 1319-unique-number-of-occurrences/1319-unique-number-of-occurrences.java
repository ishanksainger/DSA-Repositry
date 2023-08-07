class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            if(list.contains(mp.getValue())){
                return false;
            }
            list.add(mp.getValue());
        }
        return true;
    }
}