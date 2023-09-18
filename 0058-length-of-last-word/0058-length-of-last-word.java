class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int num=s.lastIndexOf(" ");
        return s.substring(num+1).length();
    }
}