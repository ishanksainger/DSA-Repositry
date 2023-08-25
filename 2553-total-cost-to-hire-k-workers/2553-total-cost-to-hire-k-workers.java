class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        int i=0,j=costs.length-1;
        PriorityQueue<Integer> pqLeft=new PriorityQueue<>();
        PriorityQueue<Integer> pqRight=new PriorityQueue<>();
        long ans=0;
        while(k-- >0){
            while(pqLeft.size()<candidates && i<=j){
                pqLeft.offer(costs[i++]);
            }
            while(pqRight.size()<candidates && i<=j){
                pqRight.offer(costs[j--]);
            }
            int t1=pqLeft.size()>0 ? pqLeft.peek() : Integer.MAX_VALUE;
            int t2=pqRight.size()>0 ? pqRight.peek() : Integer.MAX_VALUE;

            if(t1<=t2){
                ans+=t1;
                pqLeft.poll();
            }
            else{
                ans+=t2;
                pqRight.poll();
            }
        }
        return ans;
    }
}