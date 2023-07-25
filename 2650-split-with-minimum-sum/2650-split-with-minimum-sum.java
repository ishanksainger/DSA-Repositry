class Solution {
    public int splitNum(int num) {
        int[] array=new int[Integer.toString(num).length()];
        int i=0;
        while (num>0){
            array[i]=num%10;
            num=num/10;
            i++;
        }
        StringBuilder num1= new StringBuilder();
        StringBuilder num2= new StringBuilder();
        Arrays.sort(array);

        for (int j=0;j<array.length;j++){
            if (j%2==0){
                num1.append(Integer.toString(array[j]));

            }
            else {
                num2.append(Integer.toString(array[j]));

            }
        }
        return Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString());
    }
}