class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        return binarySearch(max,piles,h);
    }
    public int binarySearch(int end, int[] piles, int h){
        int start=1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int hours=checkHours(piles,mid);
            if(hours>h){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
    public int checkHours(int[]piles, int h){
        int totalH=0;

        int n=piles.length;
        for(int i=0;i<n;i++){
            totalH+= Math.ceil((double)(piles[i]) / (double)(h));
        }
        return totalH;
    }
}