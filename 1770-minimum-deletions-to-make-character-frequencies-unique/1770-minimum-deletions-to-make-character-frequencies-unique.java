class Solution {
    public int minDeletions(String s) {
        int[] chars=new int[26];
        for(char ch: s.toCharArray()){
            chars[ch-'a']++;
        }

        Arrays.sort(chars);
        int deleteChar=0;

        for(int i=24;i>=0;i--){
            if(chars[i]==0){
                break;
            }
            if(chars[i]>=chars[i+1]){
                int prev=chars[i];
                chars[i]=Math.max(0, chars[i+1]-1);
                deleteChar+=prev-chars[i];
            }
        }
        return deleteChar;
    }
}