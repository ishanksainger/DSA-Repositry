class Solution {
    class Edge{
        int count;
        String word;
        Edge(int count, String word){
            this.count=count;
            this.word=word;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Edge> queue=new LinkedList<>();
        Set<String> set=new HashSet<>(wordList);
        queue.add(new Edge(1,beginWord));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int c=e.count;
            String s=e.word;
            if(s.equals(endWord)){
                return c;
            }
            for(int i=0;i<s.length();i++){
                for(char j='a';j<='z';j++){
                    char[] ch=s.toCharArray();
                    ch[i]=j;
                    String str=String.valueOf(ch);
                    if(set.contains(str)){
                        set.remove(str);
                        queue.add(new Edge(c+1,str));
                    }
                }
            }
        }
        return 0;
    }
}