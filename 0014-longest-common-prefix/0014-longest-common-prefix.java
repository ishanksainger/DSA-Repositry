class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        Arrays.sort(strs);
        int len=Math.min(strs[0].length(),strs[n-1].length());
        String start=strs[0],end=strs[n-1];
        String str="";
        for(int i=0;i<len;i++){
            if(start.charAt(i)!=end.charAt(i)){
                return str;
            }
            str+=Character.toString(start.charAt(i));
        }
        return str;
    }
}