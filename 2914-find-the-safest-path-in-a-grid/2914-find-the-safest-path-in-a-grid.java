class Solution {
    class Pair{
        int row, col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int[][] matrix=new int[n][n];
        for(int[] num: matrix){
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j)==1){
                    bfs(grid, i, j, matrix);
                }
            }
        }
        int smallest=Integer.MAX_VALUE,largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                smallest=Math.min(smallest,matrix[i][j]);
                largest=Math.max(largest,matrix[i][j]);
            }
        }
        int ans=0;
        while(smallest<=largest){
            int mid=smallest+(largest-smallest)/2;
            if(isPossible(mid,matrix)){
                ans=mid;
                smallest=mid+1;
            }
            else{
                largest=mid-1;
            }
        }
        return ans;

    }
    public void bfs(List<List<Integer>> grid, int row, int col ,int[][] matrix){
        matrix[row][col]=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(row,col));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<grid.size() && nCol>=0 && nCol<grid.size() && matrix[nRow][nCol]>matrix[r][c]+1){
                    queue.add(new Pair(nRow,nCol));
                    matrix[nRow][nCol]=matrix[r][c]+1;
                }
            }
        }
    }
    public boolean isPossible(int mid, int[][] matrix){
        int n=matrix.length;
        if(matrix[0][0]<mid || matrix[n-1][n-1]<mid){
            return false;
        }
        Queue<Pair> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];
        queue.add(new Pair(0,0));
        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int r=p.row;
            int c=p.col;
            if(visited[r][c]) continue;
            visited[r][c]=true;
            for(int i=0;i<4;i++){
                int nRow=r+moveRow[i];
                int nCol=c+moveCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && matrix[nRow][nCol]>=mid){
                    queue.add(new Pair(nRow,nCol));
                }
            }

        }
        return visited[n-1][n-1];
    }
}