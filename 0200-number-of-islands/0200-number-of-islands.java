class Solution {
    class Edge{
        int row, col;
        Edge(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(grid, visited, m,n, i, j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int[][] visited, int m, int n, int ro, int co){
        Queue<Edge> queue=new LinkedList<>();
        queue.add(new Edge(ro,co));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!queue.isEmpty()){
            int r=queue.peek().row;
            int c=queue.peek().col;
            queue.remove();
            for(int i=0;i<4;i++){
                int nextRow=r+moveRow[i];
                int nextCol=c+moveCol[i];
                if(nextRow>=0 && nextRow<m && nextCol>=0 && nextCol<n && visited[nextRow][nextCol]==0 && grid[nextRow][nextCol]=='1'){
                    visited[nextRow][nextCol]=1;
                    queue.add(new Edge(nextRow, nextCol));
                }
            }
        }
    }
}