class DisJoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    DisJoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
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
    public void byRank(int u, int v){
        int uParent=ultParent(u);
        int vParent=ultParent(v);
        if(uParent==vParent) return;
        if(rank.get(uParent)>rank.get(vParent)){
            parent.set(vParent, uParent);
        }
        else if(rank.get(uParent)< rank.get(vParent)){
            parent.set(uParent, vParent);
        }
        else{
            parent.set(vParent,uParent);
            int rankU=rank.get(uParent);
            rank.set(uParent, rankU+1);
        }
    }
    public void bySize(int u, int v){
        int uParent=ultParent(u);
        int vParent=ultParent(v);
        if(uParent==vParent) return;
        if(size.get(uParent)>size.get(vParent)){
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent)+size.get(vParent));
        }
        else{
            parent.set(uParent,vParent);
            size.set(vParent, size.get(uParent)+size.get(vParent));

        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisJoint ds=new DisJoint(n);
        int extraEdges=0;
        int m=connections.length;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.ultParent(u)==ds.ultParent(v)){
                extraEdges++;
            }
            else{
                ds.bySize(u,v);
            }
        }
        int ans=0;
        int singleParent=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                singleParent++;
            }
        }
        ans=singleParent-1;
        if(extraEdges>=ans){
            return ans;
        }
        return -1;
    }
}