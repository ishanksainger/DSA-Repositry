class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        Map<String, Integer> map=new HashMap<>();
        for(int[] rows: grid){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<n;i++){
                str.append(rows[i]);
                str.append(" ");
            }
            String s=str.toString();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int count=0;
        for(int i=0;i<n;i++){
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++){
                str.append(grid[j][i]);
                str.append(" ");
            }
            String dummy=str.toString();
            if(map.get(dummy)!=null){
                count+=map.get(dummy);
            }
        }
        return count;
    }

}