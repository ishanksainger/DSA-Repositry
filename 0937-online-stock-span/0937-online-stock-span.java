class StockSpanner {
    List<Integer> list;

    public StockSpanner() {
        list=new ArrayList<>();
    }
    
    public int next(int price) {
        int count=1,index=list.size()-1;
        while(!list.isEmpty() && index>=0 && list.get(index)<=price){
            count++;
            index--;
        }
        list.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */