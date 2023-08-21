class Solution {
    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair> queue=new LinkedList<>();
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        queue.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }
        int[] moveRow={-1, 0, 1, 0};
        int[] moveCol={0, 1, 0, -1};

        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int nextRow=r+moveRow[i];
                int nextCol=c+moveCol[i];
                if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol <m && visited[nextRow][nextCol]==0 && 
                board[nextRow][nextCol]=='O'){
                    queue.add(new Pair(nextRow, nextCol));
                    visited[nextRow][nextCol]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                   board[i][j]='X';
                }
            }
        }
    }
}