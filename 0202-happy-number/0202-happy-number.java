class Solution {
    public boolean isHappy(int n) {
        int j=0;
        while(j++<10){
            int plus=0;
            while(n!=0){
                int num=n%10;
                n=n/10;
                plus+=num*num;
            }
            if(plus==1) return true;
            n=plus;
        }    
        return false;
    }
}