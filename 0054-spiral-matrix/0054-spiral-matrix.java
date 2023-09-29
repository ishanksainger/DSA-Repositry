class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int left=0,up=0,right=matrix[0].length-1,down=matrix.length-1;
        int directions=0;
        while(left<=right && up<=down){
            if(directions==0){
                for(int i=left;i<=right;i++){
                    list.add(matrix[up][i]);
                }
                up++;
            }
            else if(directions==1){
                for(int i=up;i<=down;i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            else if(directions==2){
                for(int i=right;i>=left;i--){
                    list.add(matrix[down][i]);
                }
                down--;
            }
             else if(directions==3){
                for(int i=down;i>=up;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            directions++;
            directions=directions%4;
        }
        return list;
    }
}