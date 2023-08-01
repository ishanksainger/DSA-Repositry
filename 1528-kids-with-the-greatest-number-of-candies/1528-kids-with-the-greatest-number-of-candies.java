class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        int max=0;
        List<Boolean> list=new ArrayList<>();
        for(int num: candies){
            max=Math.max(max,num);
        }
        for(int i=0;i<n;i++){
            int num=candies[i]+extraCandies;
            if(num>=max){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}