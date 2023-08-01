class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> newList=new ArrayList<>();
        newList.add(0);
        helper(list, newList, graph,0);
        return list;
    }
    public void helper(List<List<Integer>> list, List<Integer> newList,int[][] graph, int index ){
        if(index==graph.length-1){
            list.add(new ArrayList<>(newList));
            return;
        }
        int[] nums=graph[index];
        for(int num:nums){
            newList.add(num);
            helper(list,newList,graph,num);
            newList.remove(newList.size()-1);
        }
    }
}