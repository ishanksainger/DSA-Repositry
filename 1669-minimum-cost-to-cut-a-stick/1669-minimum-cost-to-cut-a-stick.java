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
        // for tabulation we are increasing the size
        int[][] dp=new int[c+2][c+2];
        // in tabulation we do opposite of recursion so we start from c instead of in i and in j we start from 1 instead
        //of c
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j){
                    continue;
                }
                // this below function will remain same;
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int ans=list.get(j+1)-list.get(i-1) + dp[i][k-1] + dp[k+1][j];
                    min=Math.min(min,ans);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][c];
    }
}