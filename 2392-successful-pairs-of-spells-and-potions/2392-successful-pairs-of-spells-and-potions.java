class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int[] result=new int[n];
        int m=potions.length;
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int num=binarySearch(spells[i],potions,success);
            if(num!=-1){
                result[i]=m-num;
            }
        }
        return result;
    }
    public int binarySearch(int num, int[]potions, long success){
        int i=0;
        int j=potions.length-1;
        int idx=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if((long)potions[mid]*num>=success){
                idx=mid;
                j=mid-1;
            }
            else if(potions[mid]*num<success){
                i=mid+1;
            }
        }
        if(idx==-1){
            return -1;
        }
        return idx;
    }
}