class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=t.length();
        int m=s.length();
        if(m<1){
            return true;
        }
        if(n<1){
            return false;
        }
        int count=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(s.charAt(j)==t.charAt(i)){
                count++;
                i++;
                j++;
            }
            else{
                i++;
            }
            if(count==m){
                return true;
            }
        }
        return false;
    }
}