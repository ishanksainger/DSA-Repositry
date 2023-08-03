class Solution {
    class Edge{
        int row,col,time;
        Edge(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Edge> queue=new LinkedList<>();
        int n= grid.length;
        int m=grid[0].length;
        boolean[][]visited=new boolean[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    queue.add(new Edge(i,j,0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int cntFresh=0;
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        int time=0;
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int r=e.row;
            int c=e.col;
            int t=e.time;
            time=Math.max(time,t);
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]==1){
                    visited[nRow][nCol]=true;
                    queue.add(new Edge(nRow,nCol, t+1));
                    cntFresh++;
                }
            }
        }
        if(fresh!=cntFresh){
            return -1;
        }
        return time;
    }
}