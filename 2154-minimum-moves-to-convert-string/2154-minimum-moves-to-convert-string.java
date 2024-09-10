class Solution {
    public int minimumMoves(String s) {
        int n=s.length();
        int i=0;
        int result=0;
        while(i<s.length()){
            if(s.charAt(i)=='X'){
                i+=3;
                result++;
            }
            else{
                i++;
            }
        }
        return result;
    }
}