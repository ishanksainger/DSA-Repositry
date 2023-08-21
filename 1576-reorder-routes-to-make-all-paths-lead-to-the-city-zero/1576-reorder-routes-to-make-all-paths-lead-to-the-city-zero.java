class Solution {
    int change;

    public int minReorder(int n, int[][] connections) {
        change = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int m = connections.length;
        for (int i = 0; i < m; i++) {
            int n1 = connections[i][0];
            int n2 = connections[i][1];
            list.get(n1).add(n2); // Represents a forward connection from n1 to n2
            list.get(n2).add(-n1); // Represents a reverse connection from n2 to n1
        }
        boolean[] visited = new boolean[n];
        dfs(list, visited, 0);
        return change;
    }

    public void dfs(List<List<Integer>> list, boolean[] visited, int from) {
        visited[from] = true;
        for (int num : list.get(from)) {
            if (!visited[Math.abs(num)]) {
                if (num > 0) {
                    change++; // Increment change only when the connection direction changes
                }
                dfs(list, visited, Math.abs(num));
            }
        }
    }
}
