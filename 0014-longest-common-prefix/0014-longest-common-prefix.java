class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int i=0;
        HashMap<String,Integer> map=new HashMap<>();
        while(i<n){
            String str="";
            for(int j=0;j<strs[i].length();j++){
                str+=Character.toString(strs[i].charAt(j));
                map.put(str,map.getOrDefault(str,0)+1);
            }
            i++;
        }
        String result="";
        int max=0;
        for(Map.Entry<String,Integer> mp:map.entrySet()){
            int value=mp.getValue();
            String key=mp.getKey();
            if(value>=max && key.length() > result.length() && value>=n){
                max=value;
                result=key;
            }
        }
        return result;
    }
}