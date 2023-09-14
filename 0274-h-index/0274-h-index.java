class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int num=0,paper=0;
        for(int i=0;i<n;i++){
            int len=n-i;
            if(len>=citations[i]){
                num=Math.max(num,citations[i]);
            }
            else{
                paper++;
            }
        }
        return Math.max(num,paper);
    }
}