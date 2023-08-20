class Solution {
    class Edge implements Comparable<Edge>{
        int row, col,wt;
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
        int m=heights.length;
        int n=heights[0].length;
        int[][] distance =new int[m][n];
        for(int[] num: distance){
            Arrays.fill(num,Integer.MAX_VALUE);
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
            if(r==m-1 && c==n-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nCol>=0 && nRow<m && nCol<n){
                   int max=Math.max(d,Math.abs(heights[r][c]-heights[nRow][nCol]));
                    if(max<distance[nRow][nCol]){
                        distance[nRow][nCol]=max;
                        pq.add(new Edge(nRow,nCol,max));
                    }
                }

            }
        }
        return 0;
    }
}