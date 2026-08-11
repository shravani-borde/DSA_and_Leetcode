class Solution {
    public int recurssion(int n, int k){
        if(n==1)
            return 0;
        return (  recurssion(n-1, k) + k) % n;
    }
    public int findTheWinner(int n, int k) {
        return recurssion(n, k) + 1;
    }
}