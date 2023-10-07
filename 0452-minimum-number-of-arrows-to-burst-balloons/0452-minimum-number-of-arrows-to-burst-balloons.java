class Solution {
    class Pair implements Comparable<Pair>{
        long x,y;
        Pair(long x, long y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Pair p){
            return Long.compare(this.y, p.y);
        }
    }
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        int count=0;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            long x=points[i][0];
            long y=points[i][1];
            list.add(new Pair(x,y));
        }
        Collections.sort(list);

        long x=list.get(0).x;
        long y=list.get(0).y;
        for(int i=1;i<list.size();i++){
            long num1=list.get(i).x;
            long num2=list.get(i).y;
            if(num1<=y){
                count++;
            }
           else {
                x = num1;
                y = num2;
            }
        }
        if(count==0){
            return list.size();
        }
        else if((list.size()%count!=0) || (count==1)){
            int num=count*2;
            return (list.size()-num)+count;
        }
        return count;
    }
}