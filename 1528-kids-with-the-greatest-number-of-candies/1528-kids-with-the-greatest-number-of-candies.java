class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        List<Boolean> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            pq.add(candies[i]);
        }
        for(int i=0;i<n;i++){
            int num=candies[i]+extraCandies;
            pq.add(num);
            if(pq.peek()==num){
                list.add(true);
            }
            else{
                list.add(false);
            }
            pq.remove(num);
        }
        return list;
    }
}