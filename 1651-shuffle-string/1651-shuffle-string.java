class Solution {
    public String restoreString(String s, int[] indices) {
        int n=indices.length;
        char[] ch=s.toCharArray();
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<n;i++){
           str.setCharAt(indices[i],ch[i]);
        }
        return str.toString();
    }
}