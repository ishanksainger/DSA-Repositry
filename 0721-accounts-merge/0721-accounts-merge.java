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
        Map<String, Integer> map=new HashMap<>();
        int n=accounts.size();
        DisJoint ds=new DisJoint(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String node=accounts.get(i).get(j);
                if(!map.containsKey(node)){
                    map.put(node,i);
                }
                else{
                    ds.unionbySize(map.get(node),i);
                }
            }
        }
        List<String> list[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        for(Map.Entry<String, Integer> mp:map.entrySet()){
            String s=mp.getKey();
            int val=mp.getValue();
            int parent=ds.findUltParent(val);
            list[parent].add(s);
        }
        List<List<String>> ansList=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list[i].size()==0) continue;
            Collections.sort(list[i]);
            String item1=accounts.get(i).get(0);
            List<String> newList=new ArrayList<>();
            newList.add(item1);
            for(String items:list[i]){
                newList.add(items);
            }
            ansList.add(newList);
        }
        return ansList;
    }
}