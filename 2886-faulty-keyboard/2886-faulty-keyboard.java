class Solution {
    public String finalString(String s) {
        StringBuilder str=new StringBuilder();
        int n=s.length();
        for(int word=0;word<n;word++){
            if(s.charAt(word)=='i'){
                str.reverse();
            }
            else{
                str.append(s.charAt(word));
            }
        }
        return str.toString();
    }
}