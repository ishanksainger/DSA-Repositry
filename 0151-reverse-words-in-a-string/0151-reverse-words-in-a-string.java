class Solution {
    public String reverseWords(String s) {
        s=s.trim().replaceAll("\\s+"," ");
        String result="";
        String[] str=s.split(" ");
        for (int i=0,j=str.length-1;i<j;i++,j--){
            String temp=str[j];
            str[j]=str[i];
            str[i]=temp;
        }
        result=String.join(" ",str);
        return result;
    }
}