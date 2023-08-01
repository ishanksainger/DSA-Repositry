class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        if(flowerbed[0]==0 && flowerbed.length==1 || flowerbed[0]==0 && flowerbed[1]==0) {
            flowerbed[0]=1;
            count++;
        } 
        for (int i=1;i<flowerbed.length;i++){
           if((i==flowerbed.length-1 && flowerbed[i-1]==0 || flowerbed[i-1]==0 && flowerbed[i+1]==0)  && flowerbed[i]==0){
               flowerbed[i]=1;
               count++;
           }
    }
    if(count>=n){
        return true;
    }
    return false;
    }
}