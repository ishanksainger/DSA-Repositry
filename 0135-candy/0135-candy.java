class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        for(int i=0;i<n;i++){
     
          if(i>0 && i<n-1 && ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1]){
            candies[i]=candies[i-1]+1;
          }
          else if(i!=0 && ratings[i]>ratings[i-1]){
            candies[i]=candies[i-1]+1;
          }
          else if(i!=n-1 && ratings[i]>ratings[i+1]){
            candies[i]=candies[i+1]+1;
            while(i>0 && candies[i]==candies[i-1] && ratings[i]<ratings[i-1]){
              candies[i-1]++;
              i--;
            }
          }
        }
        int sum=0;
        for(int i=0;i<n;i++){
          // System.out.println(candies[i]);
          sum+=candies[i]+1;
        }
        return sum;
    }
}