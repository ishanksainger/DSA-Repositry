class Solution {
    class Edge{
        int row,col;
        Edge(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int row, int col,char[][] grid, boolean[][] visited){
        Queue<Edge> queue=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        queue.add(new Edge(row,col));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int r=e.row;
            int c=e.col;
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]=='1'){
                    queue.add(new Edge(nRow,nCol));
                    visited[nRow][nCol]=true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}