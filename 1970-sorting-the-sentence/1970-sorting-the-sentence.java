class Solution {
    public String sortSentence(String s) {
        String[] str=s.split(" ");
        int n=str.length;
        String[] newStr=new String[n];
        for(String string:str){
            char num=string.charAt(string.length()-1);
            string=string.substring(0,string.length()-1);
            newStr[(num-'0')-1]=string;
        }
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<n;i++) {
            sb.append(newStr[i]);
            if(i==n-1){
                continue;
            }
            sb.append(" ");
        }
        return sb.toString();

        
    }
}