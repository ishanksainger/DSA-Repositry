class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];

        for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]){
            candies[i]=candies[i-1]+1;
          }
        }
         for(int i=n-2;i>-1;i--){
          if(ratings[i]>ratings[i+1]){
            if(candies[i+1]>=candies[i]){
              candies[i]=candies[i+1]+1;
            }
          }
        }
        
        int sum=0;
        for(int i=0;i<n;i++){
          sum+=candies[i]+1;
        }
        return sum;
    }
}