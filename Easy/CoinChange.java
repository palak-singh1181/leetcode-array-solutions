public class CoinChange {

    static int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins required to make amount i
        int[] dp = new int[amount + 1];

        // Initially, assume every amount is impossible
        int max = amount + 1;

        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }

        // 0 amount needs 0 coins
        dp[0] = 0;

        // Calculate minimum coins for every amount
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {

                    dp[i] = Math.min(
                            dp[i],
                            dp[i - coin] + 1
                    );
                }
            }
        }

        // If amount cannot be formed
        if (dp[amount] == max) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        int answer = coinChange(coins, amount);

        System.out.println("Minimum coins: " + answer);
    }
}
