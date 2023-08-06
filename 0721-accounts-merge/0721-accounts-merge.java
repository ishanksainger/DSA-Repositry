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
        if(size.get(uParent)<rank.get(vParent)){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map=new HashMap<>();
        int n=accounts.size();
        DisJointSet ds=new DisJointSet(n);
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
        List<String> list[] =new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        for(Map.Entry<String, Integer> mp: map.entrySet()){
            String str=mp.getKey();
            int num=ds.ultParent(mp.getValue());
            list[num].add(str);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list[i].size()==0){
                continue;
            }
            Collections.sort(list[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String num:list[i]){
                temp.add(num);
            }
            ans.add(temp);
        }
        return ans;
    }
}