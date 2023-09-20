class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s; // No need to change the string for numRows == 1
        }
        List<StringBuilder> list= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int n=s.length(),index=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            list.get(index).append(s.charAt(i));
            if(flag){
                index++;
            }
            else{
                index--;
            }
            if(index==numRows-1 || index==0){
                flag=!flag;
            }
        }
        String str="";
        int size=list.size();
        for(int i=0;i<size;i++){
            str+=list.get(i).toString();
        }
        return str;
    }
}