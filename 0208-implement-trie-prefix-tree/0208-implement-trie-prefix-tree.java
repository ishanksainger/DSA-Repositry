class Trie {
    List<String> list;
    public Trie() {
        list=new ArrayList<>();
    }
    
    public void insert(String word) {
        list.add(word);
    }
    
    public boolean search(String word) {
        if(!list.contains(word)){
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        for(String item:list){
            if(item.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */