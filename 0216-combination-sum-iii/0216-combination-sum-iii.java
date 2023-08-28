class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int num=10;
        List<List<Integer>> list=new ArrayList<>();
        helper(list,1,n,k,new ArrayList<>(),k);
        return list;
    }
    public void helper(List<List<Integer>> list,int start, int target, int k, List<Integer> num,int counter){
        if(target==0 && k==0){
            if(num.size()==counter){
                 list.add(new ArrayList<>(num));
            }
            return;

        }
   
        for(int i=start;i<10;i++){
            if(i>target){
                break;
            }
            num.add(i);
            helper(list,i+1,target-i,k-1,num,counter);
            num.remove(num.size()-1);
        }
    }
}