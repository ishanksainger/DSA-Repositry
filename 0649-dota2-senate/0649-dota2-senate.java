class Solution {
    public String predictPartyVictory(String senate) {
        int count=0;
        int n=senate.length();
        Queue<Integer> Rqueue=new LinkedList<>();
        Queue<Integer> Dqueue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='D'){
                Dqueue.add(i);
            }
            else{
                Rqueue.add(i);
            }
        }
        while(!Dqueue.isEmpty() && !Rqueue.isEmpty()){
            int d=Dqueue.remove();
            int r=Rqueue.remove();
            if(d<r){
                Dqueue.add(d+n);
            }
            else{
                Rqueue.add(r+n);
            }
        }
        if(Dqueue.isEmpty()){
            return "Radiant";
        }
        return "Dire";
    }
}