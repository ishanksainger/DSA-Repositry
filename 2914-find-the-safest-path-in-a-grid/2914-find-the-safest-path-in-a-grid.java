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
        // after storing small and large of the matrix array and then we get the mid and send to ispossible func because we want to
        // know whether there are safest nodes from 1 and if not we return false and then we reduce largest else increase small and keep
        // calculating mid/ intution is mid helps us to determin which nodes are far from 1 and should not be next node .
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
    // this gets the total safest nodes from 1 and store in matrix
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
    // this function tells if the greater than mid are there in the matrix and they are safest so we return visited with the updated 
    //  boolean
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
        // it is asked in question to get till last corner which is the safest cell, that is why we are sending this
        return visited[n-1][n-1];
    }
}