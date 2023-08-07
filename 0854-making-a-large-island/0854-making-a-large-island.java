class DisJointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    DisJointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int ultParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int newParent=ultParent(parent.get(node));
        parent.set(node, newParent);
        return parent.get(node);
    }
    public void unionbyRank(int u, int v){
        int uParent=ultParent(u);
        int vParent=ultParent(v);
        if(uParent==vParent) return;
        if(rank.get(uParent)<rank.get(vParent)){
            parent.set(uParent, vParent);
        }
        else if(rank.get(uParent)> rank.get(vParent)){
            parent.set(vParent, uParent);
        }
        else{
            parent.set(uParent,vParent);
            rank.set(uParent,rank.get(uParent)+1);
        }
    }
    public void unionbySize(int u, int v){
        int uParent=ultParent(u);
        int vParent=ultParent(v);
        if(uParent==vParent) return;
        if(size.get(uParent)<size.get(vParent)){
            parent.set(uParent, vParent);
            size.set(vParent,size.get(uParent)+size.get(vParent));
        }
        else{
            parent.set(vParent, uParent);
            size.set(uParent,size.get(uParent)+size.get(vParent));
        }
    }
}
class Solution {
    private boolean isValid(int row, int col,int n){
        return row>=0 && row<n && col>=0 && col<n; 
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisJointSet ds=new DisJointSet(n*n);
        
        //step-1 we will attach all the 1 which is mentioned and set their unionbysize.

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                int[] moveRow={-1,0,1,0};
                int[] moveCol={0,1,0,-1};
                for(int k=0;k<4;k++){
                    int nRow=i+moveRow[k];
                    int nCol=j+moveCol[k];
                    if(isValid(nRow,nCol,n) && grid[nRow][nCol]==1){
                        int nodeNo=i *n + j;
                        int adjNode=nRow * n + nCol;
                        ds.unionbySize(nodeNo,adjNode);
                    }
                }
            }
        }
        //step 2 in this we will try to set 0 to 1 and check max coverage and save it in hashset
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                int[] moveRow={-1,0,1,0};
                int[] moveCol={0,1,0,-1};
                HashSet<Integer> set=new HashSet<>();
                for(int k=0;k<4;k++){
                    int nRow=i+moveRow[k];
                    int nCol=j+moveCol[k];
                    if(isValid(nRow,nCol,n)){
                        if(grid[nRow][nCol]==1){
                            set.add(ds.ultParent(nRow*n+nCol));
                        }
                    }
                }
                int sizeTotal=0;
                for(int parents:set){
                    sizeTotal+=ds.size.get(parents);
                }
                max=Math.max(max,sizeTotal + 1);
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max, ds.size.get(i));
        }
        return max;
    }
}