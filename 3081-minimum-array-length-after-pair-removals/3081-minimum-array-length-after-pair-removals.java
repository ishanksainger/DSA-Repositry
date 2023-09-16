class Pair{
    int element,occurence;
    Pair(int element, int occurence){
        this.element=element;
        this.occurence=occurence;
    }
}
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
       int n=nums.size(),value=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> y.occurence-x.occurence);

        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            pq.add(new Pair(mp.getKey(),mp.getValue()));
        }

        while(pq.size()>1){
            Pair num1=pq.poll();
            Pair num2=pq.poll();

            int value1=num1.occurence-1;
            int value2=num2.occurence-1;

            if(value1>=1){
                pq.add(new Pair(num1.element,value1));
            }
            if(value2>=1){
                pq.add(new Pair(num2.element,value2));
            }
        }
        int num=0;
        while(!pq.isEmpty()){
            num+=pq.poll().occurence;
        }
        return num;
       
    }
}


