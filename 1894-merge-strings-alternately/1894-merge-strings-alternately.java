class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        String str="";
        for(int i=0;i<n+m;i++){
            if(i==n && i==m){
                break;
            }
            else if(i==n){
                str+=word2.substring(i,m);
                 break;
            }
            else if(i==m){
                str+=word1.substring(i,n);
                 break;
            }
            str+=word1.charAt(i);
            str+=word2.charAt(i);
        }
        return str;
    }
}