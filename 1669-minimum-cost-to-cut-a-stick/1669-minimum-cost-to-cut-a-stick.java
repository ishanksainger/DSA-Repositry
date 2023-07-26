class Solution {
    public int minCost(int n, int[] cuts) {
        // we convert the cuts array to list because we need to include 0 and n in the cuts array.
        List<Integer> list=Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0,0);
        list.add(n);
        // we sort the list so that we can cut the stick in a normaly way and sequntial way.
        Collections.sort(list);
        //orignal cuts length
        int c=cuts.length;
        int[][] dp=new int[c+1][c+1];
        for(int[] nums: dp){
            Arrays.fill(nums, -1);
        }
        // 1 is the 1st index that we send because we have added 0 and n, so normal cuts start from 1 to n-1.
        return helper(dp,list,1, c);
    }
    public int helper(int[][]dp, List<Integer> list, int i, int j){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        // we are not sure which cuts array is needed to be sent to we send one by 1 from i till j
        for(int k=i;k<=j;k++){
            // in this we first get i-1 and j+1 and minus them to get the exact length from which the stick is broken
            //and after breaking the stick apart from this number we get left list 1st number and last number and right 
            // list 1st number till last number
            int ans=list.get(j+1)-list.get(i-1) + helper(dp, list, i,k-1) + helper(dp, list, k+1, j);
            // and keepp getting min
            min=Math.min(min,ans);
        }
        //once done we save it to dp ij and return.
       return dp[i][j]=min;
    }
}