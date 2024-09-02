class Solution {
    public boolean squareIsWhite(String coordinates) {
        int num1 = coordinates.charAt(0) - 'a';
        int num2 = coordinates.charAt(1);
        return (num1 + 1 + num2) % 2 == 0 ? false : true;
    }
}