class Solution {
    class Pair implements Comparable<Pair>{
        int index,elem;
        Pair(int index,int elem){
            this.index=index;
            this.elem=elem;
        }

        public int compareTo(Pair p){
            return p.elem-this.elem;
        }
    }
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n =nums2.length;
        Pair[] newArray=new Pair[n];
        for(int i=0;i<n;i++){
            newArray[i]=new Pair(i,nums2[i]);
        }
        Arrays.sort(newArray);
        long sum=0;
        for(int i=0;i<k;i++){
            Pair p=newArray[i];
            pq.add(nums1[p.index]);
            sum+=nums1[p.index];
        }
        long res=sum*(newArray[k-1].elem);

        for(int i=k;i<n;i++){
            if(pq.size()==k){
                sum-=pq.poll();
            }
            Pair p=newArray[i];
            pq.add(nums1[p.index]);
            sum+=nums1[p.index];
            res=Math.max(res,sum*(newArray[i].elem));
        }
        return res;
    }
}