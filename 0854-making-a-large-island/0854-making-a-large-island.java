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
    public boolean isValid(int row, int col, int n){
        return (row>=0 && col>=0 && row<n && col<n );
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;

        DisJointSet ds=new DisJointSet(n*n);

        int[] moveRow={-1,0,1,0};
        int[] moveCol={0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==0) continue;

                else{
                    for(int k=0;k<4;k++){
                        int nRow=i+moveRow[k];
                        int nCol=j+moveCol[k];
                        if(isValid(nRow,nCol,n) && grid[nRow][nCol]==1){
                            int u=i*n+j;
                            int v=nRow*n+nCol;
                            ds.unionbySize(u,v);
                        }
                    }
                }
            }
        }       
        int totalSize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                else{
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nRow=i+moveRow[k];
                        int nCol=j+moveCol[k];
                        if(isValid(nRow,nCol,n) && grid[nRow][nCol]==1){
                            int v=nRow*n+nCol;
                            set.add(ds.ultParent(v));
                        }
                    }
                    int size=0;
                    for(int num:set){
                        size+=ds.size.get(num);
                    }
                    totalSize=Math.max(totalSize,size+1);
                }
            }
        }    
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int item=i*n+j;
                totalSize=Math.max(totalSize,ds.size.get(item));
            }
        }   
        return totalSize;
    }
}