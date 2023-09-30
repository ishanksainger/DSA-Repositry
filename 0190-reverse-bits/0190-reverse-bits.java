public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       int finalResult=0;
       for (int i=0;i<32;i++){
           int result=n&1;
           int lsb=result <<(31-i);
           finalResult=finalResult|lsb;
           n=n>>1;
       }
        return finalResult;
    }
}