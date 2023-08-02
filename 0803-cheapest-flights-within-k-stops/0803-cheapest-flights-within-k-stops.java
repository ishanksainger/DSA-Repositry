class Solution {
    class Pair{
        int first,second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    class Edge{
        int src,dest,cost;
        Edge(int src, int dest, int cost){
            this.src=src;
            this.dest=dest;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> list=new ArrayList<>();
        int[] distance=new  int[n];
        Queue<Edge> queue=new LinkedList<>();
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int s=flights[i][0];
            int d=flights[i][1];
            int c=flights[i][2];
            list.get(s).add(new Pair(d,c));
        }
        queue.add(new Edge(src,0,0));
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int s=e.src;
            int d=e.dest;
            int c=e.cost;
            if(d>k) continue;
            for(Pair num:list.get(s)){
                int adjNode=num.first;
                int weight=num.second;
                if(weight+c<distance[adjNode]){
                    distance[adjNode]=weight+c;
                    queue.add(new Edge(adjNode, d+1, weight+c));
                }
            }
        }
        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];
    }
}