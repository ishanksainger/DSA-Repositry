class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0, row=matrix.length, col=matrix[0].length, end=(row*col)-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(matrix[mid/col][mid%col]==target){
                return true;
            }
            if(matrix[mid/col][mid%col]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
}