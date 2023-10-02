class Solution {
    class Edge{
        int x=0;
        int y=0;
        Edge(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Edge> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    list.add(new Edge(i,j));
                }
            }
        }
        int size=list.size();
        for(int i=0;i<size;i++){
            Edge e=list.get(i);
            int x=e.x;
            int y=e.y;
            for(int j=0,k=0;j<m || k<n;j++,k++){
                if(k<n){
                    matrix[x][k]=0;
                }
                if(j<m){
                    matrix[j][y]=0;
                }
            }
        }
    }
}