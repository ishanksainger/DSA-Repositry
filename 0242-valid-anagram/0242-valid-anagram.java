class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int m=t.length();
        if(m!=n) return false;
        
        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
       
        for(int i=0;i<n;i++){
            if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))<=0){
                return false;
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),map.get(s.charAt(i)))-1);
        }
        return true;
    }
}