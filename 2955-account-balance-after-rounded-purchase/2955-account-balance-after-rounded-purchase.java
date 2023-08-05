class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int n=0;
        n=purchaseAmount%10;
        int res=0;
        if(n>5){
           res=10-n;
           
            purchaseAmount+=res;
        }
        else if(n<5){
           
           purchaseAmount-=n;
        }
        else{
            purchaseAmount=Math.max(purchaseAmount-n, purchaseAmount+n);
        }
        return 100-purchaseAmount;
    }
}