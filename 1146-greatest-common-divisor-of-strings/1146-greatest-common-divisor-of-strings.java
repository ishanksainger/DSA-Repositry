class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        // if str1 and str2 concat dont match the other way round that means its chars are not same or repeated.
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd=getGcd(n,m);
        //it is 0 indexing we go till that number
        return str1.substring(0,gcd);
    }
    //gcd means getting the max value which is common in a and b and can divide both
    public int getGcd(int a, int b){
        // we mode a with b until b is 0 so that we can get the gcd number 
        if(b==0) return a;
        return getGcd(b,a%b);
    }
}