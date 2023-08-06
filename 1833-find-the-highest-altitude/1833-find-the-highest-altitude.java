class Solution {
    public int largestAltitude(int[] gain) {
        int max=0,n=gain.length;
        int count=0;
        for(int i=0;i<n;i++){
            count=gain[i]+count;
            max=Math.max(max,count);
        }
        return max;
    }
}