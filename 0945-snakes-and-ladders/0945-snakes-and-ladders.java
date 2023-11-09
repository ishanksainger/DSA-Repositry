class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int steps = 0;
        visited[n - 1][0] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                if (x == n * n) return steps;
                
                for (int k = 1; k <= 6; k++) {
                    int nextX = x + k;
                    if (nextX > n * n) break;
                    
                    int[] pos = newCoordinates(nextX, n);
                    int row = pos[0];
                    int col = pos[1];
                    
                    if (visited[row][col]) continue;
                    visited[row][col] = true;
                    
                    if (board[row][col] == -1) {
                        queue.add(nextX);
                    } else {
                        queue.add(board[row][col]);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }

    public int[] newCoordinates(int pos, int n) {
        int row = n - (pos - 1) / n - 1;
        int col = (pos - 1) % n;
        
        if (row % 2 == n % 2) {
            col = n - col - 1;
        }
        
        return new int[]{row, col};
    }
}
