class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map=new HashMap<>();

        int n=s.length();

        int len=words.length,wordsLength=words[0].length();

        int subStringLength=len*wordsLength;

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<len;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        for(int i=0;i<=n-subStringLength;i++){
            String str=s.substring(i,i+subStringLength);
            int j=0;
            HashMap<String,Integer> newMap=new HashMap<>();
            while(j<subStringLength){
                String string=str.substring(j,wordsLength+j);
                newMap.put(string,newMap.getOrDefault(string,0)+1);
                j+=wordsLength;
            }
            if(map.equals(newMap)){
                list.add(i);
            }
        }
        return list;
    }
}