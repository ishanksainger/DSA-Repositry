class Solution {
    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]visited=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(visited[i][j]==0 && grid[i][j]==1){
                        queue.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<m-1 && nCol>=0 && nCol<n-1 && visited[nRow][nCol]==0 && grid[nRow][nCol]==1){
                    queue.add(new Pair(nRow,nCol));
                    visited[nRow][nCol]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}