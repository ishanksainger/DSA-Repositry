class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set=new HashSet<>();
        int n=rooms.size();
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n];
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int num=queue.remove();
            set.add(num);
            if(set.size()==n){
                return true;
            }
            for(int nums: rooms.get(num)){
                if(!visited[nums]){
                    queue.add(nums);
                    visited[nums]=true;
                }
            }
        }
        return false;
    }
}