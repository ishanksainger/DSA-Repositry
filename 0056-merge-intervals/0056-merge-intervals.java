class Solution {
    public int[][] merge(int[][] intervals) {
         ArrayList<int[]> list=new ArrayList<>();
         Arrays.sort(intervals,Comparator.comparing(a->a[0]));
        int[] newInterval = new int[]{intervals[0][0], intervals[0][1]};
        for (int[] interval:intervals){
            if (interval[0]>newInterval[1]){
                list.add(newInterval);
                newInterval=interval;
            } else if (newInterval[0]>interval[1]) {
                list.add(interval);
            }
            else {
                newInterval[0]=Math.min(newInterval[0],interval[0]);
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
