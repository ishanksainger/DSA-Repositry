class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n=nums.length;
        long ans=0;
        int len= Integer.toString(nums[0]).length();
        int[][] dig=new int[10][len];

        for(int i=n-1;i>=0;i--){
            String num=Integer.toString(nums[i]);
            for(int pos=0;pos<num.length();pos++){
                int digit=num.charAt(pos)-'0';
                int total=n-i-1;
                int equal=dig[digit][pos];
                int notEqual= total-equal;
                ans+=(long)notEqual;
                dig[digit][pos]++;
            }
        }
        return ans;
    }
}