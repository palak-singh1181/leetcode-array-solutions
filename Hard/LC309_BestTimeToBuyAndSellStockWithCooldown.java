
import java.util.Scanner;

public class LC309_BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        // hold = maximum profit when we are holding a stock
        // sold = maximum profit when we sold a stock today
        // cooldown = maximum profit when we are not holding stock
        //           and are in cooldown / free state

        int hold = -prices[0];
        int sold = 0;
        int cooldown = 0;

        for (int i = 1; i < n; i++) {

            int previousHold = hold;
            int previousSold = sold;
            int previousCooldown = cooldown;

            // Buy today OR continue holding
            hold = Math.max(previousHold, previousCooldown - prices[i]);

            // Sell today
            sold = previousHold + prices[i];

            // Stay free/cooldown
            cooldown = Math.max(previousCooldown, previousSold);
        }

        return Math.max(sold, cooldown);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);

        sc.close();
    }
}