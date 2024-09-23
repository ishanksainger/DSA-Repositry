class Solution {
    public String arrangeWords(String text) {
        String[] str=text.split(" ");
        str[0]=str[0].toLowerCase();
        Arrays.sort(str,(a,b)->(a.length()-b.length()));
        str[0]=str[0].substring(0,1).toUpperCase() + str[0].substring(1);
        return String.join(" ",str);
    }
}