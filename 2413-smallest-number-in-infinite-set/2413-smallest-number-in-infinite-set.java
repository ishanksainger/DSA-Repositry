class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int smallest;
    public SmallestInfiniteSet() {
        set=new TreeSet<>();
        smallest=1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty()){
            int num=set.pollFirst();
            return num;
        }
        return smallest++;
    }
    
    public void addBack(int num) {
        if(num>=smallest){
            return;
        }
        set.add(num);
    }
}

