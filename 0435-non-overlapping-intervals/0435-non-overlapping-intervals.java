class Solution {
    class Pair implements Comparable<Pair>{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Pair p){
            return this.y-p.y;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int count=0;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=intervals[i][0];
            int y=intervals[i][1];
            list.add(new Pair(x,y));
        }
        Collections.sort(list);

        int x=list.get(0).x;
        int y=list.get(0).y;

        for(int i=1;i<list.size();i++){
            int num1=list.get(i).x;
            int num2=list.get(i).y;
            if(num1<y){
                count++;
            }
           else {
                x = num1;
                y = num2;
            }
            
        }
        return count;
    }
}