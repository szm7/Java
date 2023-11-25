public class Trade {
    static int maxProfit;
    public static int Profit(int[] sprice) {
        int n = sprice.length;
        int profit = 0;
        int buyprice = sprice[0];

        for(int i=1;i<n;i++) {
            if(sprice[i] < sprice[i-1]) {
                profit += sprice[i-1] - buyprice;
                buyprice = sprice[i];
            }

        }

        profit += sprice[n-1] -buyprice;
        return profit;
    }
    public static void main(String[] args) {
        int[] prices1 = {22,8,35,45,60,25};
        int[] prices2 = {32,40,8,6,98,34};
        System.out.println("Prices 1: " + Profit(prices1));
        System.out.println("Prices 2: " + Profit(prices2));
    }
}
