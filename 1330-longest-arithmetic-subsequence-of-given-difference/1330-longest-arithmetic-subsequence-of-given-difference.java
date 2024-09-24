class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        int ans=1;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]-difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
            }
            else{
                map.put(arr[i],1);
            }
            ans=Math.max(ans,map.get(arr[i]));
        }
        return ans;
    }
}