class Solution {
    public int maxLength(List<String> arr) {
        int[] maxLength={0};
        backTrack(arr,"",0,maxLength);
        return maxLength[0];

    }
    private void backTrack(List<String> arr, String current, int start, int[] maxLength){
        if(maxLength[0] < current.length()){
            maxLength[0] = current.length();
        }
        for(int i=start;i<arr.size();i++){
            if(!isValid(current, arr.get(i))){
                continue;
            }
            backTrack(arr, current+ arr.get(i), i+1,maxLength);
        }
    }
    private boolean isValid(String curr, String newString){
        Set<Character> set= new HashSet<>();
        for(char ch:newString.toCharArray()){
            if(set.contains(ch)) return false;
            set.add(ch);
            if(curr.contains(String.valueOf(ch))) return false;
        }
        return true;
    }
}