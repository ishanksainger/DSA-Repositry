class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> map=new HashMap<>();
        int i=0,index=0, count=0, max=0;
        for (int j=0;j<s.length();j++){
           if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i) {
                   i=map.get(s.charAt(j))+1;
                }
            count=j-i+1;
            map.put(s.charAt(j),j);
            max=Math.max(max,count);
        }
        return max;
    }
}