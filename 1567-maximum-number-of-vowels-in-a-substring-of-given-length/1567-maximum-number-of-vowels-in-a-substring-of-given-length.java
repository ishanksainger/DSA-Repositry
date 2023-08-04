class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0;
        int n=s.length();
        String str="aeiou";
        int count=0,max=Integer.MIN_VALUE;
        while(j<n){
            if(str.contains(Character.toString(s.charAt(j)))){
                count++;
            }
            if(j-i+1==k){
                max=Math.max(max,count);
                if(str.contains(Character.toString(s.charAt(i)))){
                    count--;
                }
                i++;
            }
            j++;
        }
        return max;
    }
}