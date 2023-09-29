class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int end=n-1;
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
              matrix[j][end-i]=queue.poll();
            }
        }
    }
}