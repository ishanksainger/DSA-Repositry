class Solution {
    public int[] closestDivisors(int num) {
        int[] num1=divisor(num+1);
        int[] num2=divisor(num+2);

        return (num1[1]-num1[0]<num2[1]-num2[0]) ? num1: num2;

    }
    public int[] divisor(int n){
        int[] numArray=new int[2];
        int num=(int)Math.sqrt(n);
        for(int i=num;i>0;i--){
            if(n%i==0){
                numArray[0]=i;
                numArray[1]=n/i;
                break;
            }
        }
        return numArray;
    }
}