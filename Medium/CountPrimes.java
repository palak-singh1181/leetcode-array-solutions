
public class CountPrimes {

    public static int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        // Initially all numbers are considered prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Number of primes: " + countPrimes(n));
    }
}