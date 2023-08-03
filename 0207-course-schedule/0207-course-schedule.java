class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        if(prerequisites.length<1) return true;
        int n=prerequisites.length;
        int m=prerequisites[0].length;
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] frequency=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int nums:list.get(i)){
                frequency[nums]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(frequency[i]==0){
                queue.add(i);
            }
        }
        List<Integer> newList=new ArrayList<>();
        while(!queue.isEmpty()){
            int num=queue.remove();
            newList.add(num);
            for(int nums:list.get(num)){
                frequency[nums]--;
                if(frequency[nums]==0){
                    queue.add(nums);
                }
            }
        }
        if(newList.size()==numCourses){
            return true;
        }
        return false;
    }
}