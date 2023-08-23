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
    public int findUltParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int mainParent=findUltParent(parent.get(node));
        parent.set(node,mainParent);
        return parent.get(node);
    }
    public void unionbyRank(int u, int v){
        int uParent=findUltParent(u);
        int vParent=findUltParent(v);
        if(uParent==vParent) return;
        if(rank.get(uParent)>rank.get(vParent)){
            parent.set(vParent,uParent);
        }
        else if(rank.get(uParent)<rank.get(vParent)){
            parent.set(uParent, vParent);
        }
        else{
            parent.set(vParent,uParent);
            rank.set(uParent,rank.get(uParent)+1);
        }
    }
    public void unionbySize(int u, int v){
        int uParent=findUltParent(u);
        int vParent=findUltParent(v);
        if(uParent==vParent) return;
        if(rank.get(uParent)<rank.get(vParent)){
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent)+size.get(vParent));
        }
        else{
            parent.set(uParent,vParent);
            size.set(uParent, size.get(uParent)+size.get(vParent));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisJoint ds=new DisJoint(n);
        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String str=accounts.get(i).get(j);
                if(!map.containsKey(str)){
                    map.put(str,i);
                }
                else{
                    ds.unionbySize(map.get(str),i);
                }
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(Map.Entry<String,Integer> mp: map.entrySet()){
            String str=mp.getKey();
            int node=mp.getValue();
            int parent=ds.findUltParent(node);
            list.get(parent).add(str);
        }
        List<List<String>> ansList=new ArrayList<>();
        int m=list.size();
        for(int i=0;i<m;i++){
            if(list.get(i).size()<1) continue;
            Collections.sort(list.get(i));
            String firstString=accounts.get(i).get(0);
            List<String> temp=new ArrayList<>();
            temp.add(firstString);
            for(String str:list.get(i)){
                temp.add(str);
            }
            ansList.add(temp);
        }
        return ansList;
    }
}