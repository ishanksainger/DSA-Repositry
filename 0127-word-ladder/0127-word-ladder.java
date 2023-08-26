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
        Set<String> set=new HashSet<>(wordList);
        Queue<Edge> queue=new LinkedList<>();
        set.remove(beginWord);
        queue.add(new Edge(1,beginWord));
        while(!queue.isEmpty()){
            Edge e=queue.remove();
            int count=e.count;
            String word=e.word;
            if(word.equals(endWord)){
                return count;
            }
            for(int i=0;i<word.length();i++){
                for(char j='a'; j<='z';j++){
                    char[] ch=word.toCharArray();
                    ch[i]=j;
                    String newString=new String(ch);
                    if(set.contains(newString)){
                        set.remove(newString);
                        queue.add(new Edge(count+1,newString));
                    }
                }
            }
        }
        return 0;
    }
}