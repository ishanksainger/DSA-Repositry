class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        int n=graph.length;
        boolean[] visited=new boolean[n];
        boolean[] check=new boolean[n];
        boolean[] recStack=new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int num:graph[i]){
                list.get(i).add(num);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                checkFunc(i,visited,recStack,check, list);
            }
        }
        List<Integer> newList=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]){
                newList.add(i);
            }
        }
        return newList;
    }
    public boolean checkFunc(int node, boolean[] visited, boolean[]recStack, boolean[] check, List<List<Integer>> list){
        visited[node]=true;
        recStack[node]=true;
        for(int nums: list.get(node)){
            if(!visited[nums]){
                if(checkFunc(nums,visited, recStack,check,list)){
                    return true;
                }
            }
            else{
                if(recStack[nums]){
                    return true;
                }

            }
        }
        recStack[node]=false;
        check[node]=true;
        return false;
    }
}