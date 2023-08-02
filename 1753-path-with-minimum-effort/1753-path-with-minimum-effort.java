class Solution {
    class Edge implements Comparable<Edge>{
        int row, col, dist;
        Edge(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
        public int compareTo(Edge e){
            return this.dist-e.dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int n=heights.length;
        int m=heights[0].length;
        int[][]distance=new int[n][m];
        for(int[] num:distance){
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        pq.add(new Edge(0,0,0));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!pq.isEmpty()){
            Edge e=pq.remove();
            int r=e.row;
            int c=e.col;
            int d=e.dist;
            if(r==n-1 && c==m-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m){
                    int diff=Math.max(d,Math.abs(heights[nRow][nCol]-heights[r][c]));
                    if(diff<distance[nRow][nCol]){
                        distance[nRow][nCol]=diff;
                        pq.add(new Edge(nRow,nCol,diff));
                    }
                }
            }
        }
        return 0;
    }
}