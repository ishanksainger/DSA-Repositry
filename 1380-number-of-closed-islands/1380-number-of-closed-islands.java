class Solution {
    public int closedIsland(int[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;

        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);

        boolean left = dfs(grid, i, j-1);
        boolean right = dfs(grid, i, j+1);
        
        return up && down && left && right;
    }
}