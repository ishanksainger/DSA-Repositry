class Solution {
    int count=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for( int[] arr:edges){
            int x=arr[0];
            int y=arr[1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        boolean[] visited=new boolean[n];
        dfs(0,k,values,visited,list);
        return count;
    }
    public int dfs(int index, int k, int[]values, boolean[] visited,List<List<Integer>> list){
        visited[index]=true;
        int sum=values[index];
        for(int num: list.get(index)){
            if(!visited[num]){
                sum+=dfs(num,k,values,visited,list);
            }
        }
        if(sum%k==0){
            count++;
            return 0;
        }
        return sum;
            
        }
    }
