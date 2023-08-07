class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list1.add(nums1[i]);
        }
        for(int i=0;i<m;i++){
            list2.add(nums2[i]);
        }
            
        List<Integer> copyList1 = new ArrayList<>(list1);
        list1.removeAll(list2);
        list2.removeAll(copyList1);
        Set<Integer> set1=new HashSet<>(list1);
        Set<Integer> set2=new HashSet<>(list2);
        list.add(new ArrayList<>(set1));
        list.add(new ArrayList<>(set2));
        return list;
    }
}