class Solution {
    public boolean checkZeroOnes(String s) {
        int n=s.length();
        int countZero=0, countOne=0, maxZero=0,maxOne=0;
        for(int j=0;j<n;j++){
            if(s.charAt(j)=='1'){
                countOne++;
                countZero=0;
            }           
            else{
                countZero++;
                countOne=0;
            } 
            maxOne=Math.max(maxOne, countOne);
            maxZero=Math.max(maxZero, countZero);
        }
        return maxOne>maxZero ? true: false;
    }
}