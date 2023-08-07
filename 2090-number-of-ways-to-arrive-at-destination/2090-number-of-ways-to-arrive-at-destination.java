class Solution {
    class Edge implements Comparable<Edge>{
        int node, distance;
        Edge(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
        public int compareTo(Edge e){
            return this.distance-e.distance;
        }

    }
    public int countPaths(int n, int[][] roads) {
        int MOD =(int)1e9 +7;
        PriorityQueue<Edge> pq= new PriorityQueue<>();
        List<List<Edge>> list=new ArrayList<>();
        long[] distance=new long[n];
        long[] ways=new long[n];
        int size=roads.length;
        Arrays.fill(distance, Long.MAX_VALUE);
        pq.add(new Edge(0,0));
        distance[0]=0;
        ways[0]=1;

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<size;i++){
            int r=roads[i][0];
            int c=roads[i][1];
            int d=roads[i][2];

            list.get(r).add(new Edge(c,d));
            list.get(c).add(new Edge(r,d));
        }

        while(!pq.isEmpty()){
            Edge e=pq.remove();
            long  node=e.node;
            long  dist=e.distance;
            for(Edge nums:list.get((int)node)){
                long  adjNode= nums.node;
                long  newDist=nums.distance;
                if(newDist+dist<distance[(int)adjNode]){
                    distance[(int)adjNode]=newDist+dist;
                    pq.add(new Edge((int)adjNode,(int)(newDist+dist)));
                    ways[(int)adjNode]=ways[(int)node];
                }
                else if(newDist+dist==distance[(int)adjNode]){
                    ways[(int)adjNode]=(ways[(int)adjNode]+ways[(int)node])%MOD;
                }
            }
        }
        return (int)(ways[n-1])%MOD;
    }
}