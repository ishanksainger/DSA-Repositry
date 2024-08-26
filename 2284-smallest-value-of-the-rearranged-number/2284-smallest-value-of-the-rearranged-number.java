class Solution {
    public long smallestNumber(long num) {
        int[] count=new int[10];
        long temp=num>0 ?  num: Math.abs(num);
        int min=10;

        while(temp>0){
            int rem=(int)(temp%10);
            if(rem!=0){
                min=Math.min(min,rem);
            }
            count[rem]++;
            temp/=10;
        }

        long output=0;
        if(num>0){
            output=output*10+min;
            count[min]--;

            for(int i=0;i<10;i++){
                for(int j=0;j<count[i];j++){
                    output=output*10+i;
                }
            }
        }
        else{

            for(int i=9;i>=0;i--){
                for(int j=0;j<count[i];j++){
                    output=output*10+i;
                }
            }
            output=output*-1;
        }
        return output;
    }
}