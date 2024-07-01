class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] arr: edges){
            int u=arr[0];
            int v=arr[1];
            int time=arr[2];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(new int[]{v,time});
            map.get(v).add(new int[]{u,time});
        }
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparing(a->a[1]));
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int time=curr[1];
            if(ans[node]!=-1){
                continue;
            }
            ans[node]=time;
            if(map.containsKey(node)){
                for(int[] num:map.get(node)){
                    int new_node=num[0];
                    int new_time=num[1];
                    if(ans[new_node]==-1 && time+new_time < disappear[new_node]){
                        pq.offer(new int[]{new_node, time+new_time});
                    }
                }
            }
        }
        return ans;
    }
}