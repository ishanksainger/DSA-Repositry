class Solution {
     class Edge{
        int count;
        String startGene;
        Edge(int count, String startGene){
            this.count=count;
            this.startGene=startGene;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);
        Queue<Edge> queue=new LinkedList<>();
        set.remove(startGene);
        queue.add(new Edge(0,startGene));
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int count=e.count;
            String gene=e.startGene;
            if(gene.equals(endGene)){
                return count;
            }
            for(int i=0;i<gene.length();i++){
                for(char j:"ACGT".toCharArray()){
                    char[] ch=gene.toCharArray();
                    ch[i]=j;
                    String newString=new String(ch);
                    if(set.contains(newString)){
                        set.remove(newString);
                        queue.add(new Edge(count+1,newString));
                    }
                }
            }
        }
        return -1;
    }
}