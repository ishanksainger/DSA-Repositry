class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,sum2=0;
        long count1=0,count2=0;
        
        int n=nums1.length;
        int m=nums2.length;
        
        for(int i=0;i<n;i++){
            if(nums1[i]!=0){
                sum1+=nums1[i];
            }
            else{
                count1++;
            }
        }
        for(int i=0;i<m;i++){
            if(nums2[i]!=0){
                sum2+=nums2[i];
            }
            else{
                count2++;
            }
        }
        
         if ((sum1 < sum2+count2 && count1==0 ) || (sum2 < sum1+count1 && count2== 0 )) {
            return -1;
        }
        
        return Math.max(sum1+count1,sum2+count2);
       
    }
}