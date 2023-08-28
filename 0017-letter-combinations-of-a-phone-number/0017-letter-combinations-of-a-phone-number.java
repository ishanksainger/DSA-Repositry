class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()<1) return list;
        StringBuilder str=new StringBuilder();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","utv","wxyz"};
        letterCombinationsbyRecur(digits,list,str,map,0);
        return list;
    }
    public void letterCombinationsbyRecur(String digits,List<String> list, StringBuilder str,String[] map, int index){
        if (index==digits.length()){
            list.add(str.toString());
            return;
        }
        int value=digits.charAt(index)-'0';
        String string=map[value];
        for (int i=0;i<string.length();i++){
            str.append(string.charAt(i));
            letterCombinationsbyRecur(digits,list,str,map,index+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}