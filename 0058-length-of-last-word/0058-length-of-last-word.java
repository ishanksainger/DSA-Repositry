class Solution {
    public int lengthOfLastWord(String s) {
        String resultString = s.replaceAll("\\s+", " ");
        String[] str=resultString.split(" ");
        String string=str[str.length-1];
        return string.length();
    }
}