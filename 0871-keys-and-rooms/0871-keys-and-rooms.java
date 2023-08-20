class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Set<Integer> set=new HashSet<>();
        return dfs(set,0, visited,rooms);
    }
    public boolean dfs (Set<Integer> set, int index, boolean[] visited, List<List<Integer>> rooms){
        visited[index]=true;
        set.add(index);
        
        for(int nums:rooms.get(index)){
            if(!visited[nums]){
                dfs(set,nums,visited,rooms);
            }
        }
        return set.size()==visited.length;
    }
}