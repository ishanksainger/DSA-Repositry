class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n= magazine.length();
        for(int i=0;i<n;i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        int m=ransomNote.length();
        for(int i=0;i<m;i++){
            if(map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i))>0){
                int value=map.get(ransomNote.charAt(i));
                map.put(ransomNote.charAt(i), value - 1);
            }
            else{
                return false;
            }
                    

        }
        return true;
    }
}