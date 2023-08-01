class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        if(edges.length<1) return Collections.singletonList(0);
        Queue<Integer> queue=new LinkedList<>();
        int m=edges.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        for(int i=0;i<n;i++){
            if(list.get(i).size()==1){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                int node=queue.remove();
                level.add(node);
                for(int num:list.get(node)){
                    list.get(num).remove(Integer.valueOf(node));
                    if(list.get(num).size()==1){
                        queue.add(num);
                    }
                }
            }
            ans=level;
        }
        return ans;
    }
}