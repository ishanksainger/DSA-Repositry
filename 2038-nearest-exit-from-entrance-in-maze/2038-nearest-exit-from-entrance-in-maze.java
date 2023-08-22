class Solution {
    class Edge{
        int row, col, dist;
        Edge(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Edge> queue=new LinkedList<>();
        int m=maze.length;
        int n=maze[0].length;
        boolean[][]visited=new boolean[m][n];
        queue.add(new Edge(entrance[0], entrance[1],0));
        visited[entrance[0]][entrance[1]]=true;
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        int minDist=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int r=e.row;
            int c=e.col;
            int d=e.dist;
            if (((r == 0 || r == m - 1 || c == 0 || c == n - 1) && !(r == entrance[0] && c == entrance[1]))) {
                minDist = Math.min(minDist, d);
            }
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !visited[nRow][nCol] && maze[nRow][nCol]=='.'){
                    queue.add(new Edge(nRow,nCol,d+1));
                    visited[nRow][nCol]=true;
                }
            }
        }
        if(minDist==Integer.MAX_VALUE)return -1;
        return minDist;
    }
}