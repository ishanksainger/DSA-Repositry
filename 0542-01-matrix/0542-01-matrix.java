class Solution {
    class Edge{
        int row,col,wt;
        Edge(int row, int col, int wt){
            this.row=row;
            this.col=col;
            this.wt=wt;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] visited=new boolean[n][m];
        int[][] distance=new int[n][m];
        Queue<Edge> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Edge(i, j, 0));
                    visited[i][j]=true;
                }
            }
        }
        int[] rowMove={-1,0,1,0};
        int[] colMove={0,1,0,-1};
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int r=e.row;
            int c=e.col;
            int w=e.wt;
            distance[r][c]=w;
            for(int i=0;i<4;i++){
                int nRow=rowMove[i]+ r;
                int nCol=colMove[i]+c;
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && mat[nRow][nCol]==1){
                    queue.add(new Edge(nRow, nCol, w+1));
                    visited[nRow][nCol]=true;
                }
            }
        }
        return distance;

    }
}