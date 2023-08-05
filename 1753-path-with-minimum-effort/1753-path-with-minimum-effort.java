class Solution {
    class Edge implements Comparable <Edge>{
        int row,col,wt;
        Edge(int row, int col, int wt){
            this.row=row;
            this.col=col;
            this.wt=wt;
        }
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int n=heights.length;
        int m=heights[0].length;
        int[][]distance=new int[n][m];
        for(int[] d:distance){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        pq.add(new Edge(0,0,0));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!pq.isEmpty()){
            Edge e=pq.remove();
            int r=e.row;
            int c=e.col;
            int d=e.wt;
            if(r==n-1 && c==m-1){
                return distance[n-1][m-1];
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