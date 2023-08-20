class DisJoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    DisJoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int ultParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int mainParent=ultParent(parent.get(node));
        parent.set(node,mainParent);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int uParent=ultParent(u);
        int vParent=ultParent(v);
        if(uParent==vParent)return;
        if(parent.get(uParent)<parent.get(vParent)){
            parent.set(uParent,vParent);
            size.set(vParent,size.get(uParent)+size.get(vParent));
        }
        else{
            parent.set(vParent,uParent);
            size.set(uParent,size.get(uParent)+size.get(vParent));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> set=new HashSet<>();
        int n=isConnected.length;
        DisJoint ds=new DisJoint(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            set.add(ds.ultParent(i));
        }
        return set.size();
    }
}