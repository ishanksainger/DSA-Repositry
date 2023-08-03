class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int num:graph.get(i)){
                inDegree[num]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int[] result =new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            int num=queue.peek();
            queue.remove();
            result[index++]=num;
            for(int nums:graph.get(num)){
                inDegree[nums]--;
                if(inDegree[nums]==0){
                    queue.add(nums);
                }
            }
        }
        if(index==numCourses) return result;
        return new int[0];
    }
}