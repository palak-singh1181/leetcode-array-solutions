
import java.util.*;

public class CountOfPeaksInArray {

    static class FenwickTree {
        int[] bit;
        int n;

        FenwickTree(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int delta) {
            idx++;
            while (idx <= n) {
                bit[idx] += delta;
                idx += idx & (-idx);
            }
        }

        int query(int idx) {
            idx++;
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }

        int rangeQuery(int l, int r) {
            if (l > r) return 0;
            return query(r) - (l == 0 ? 0 : query(l - 1));
        }
    }

    static boolean isPeak(int[] nums, int i) {
        if (i <= 0 || i >= nums.length - 1)
            return false;
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }

    public static List<Integer> countOfPeaks(int[] nums, int[][] queries) {

        int n = nums.length;
        FenwickTree ft = new FenwickTree(n);

        boolean[] peak = new boolean[n];

        for (int i = 1; i < n - 1; i++) {
            if (isPeak(nums, i)) {
                peak[i] = true;
                ft.update(i, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int l = q[1];
                int r = q[2];

                l = Math.max(l + 1, 1);
                r = Math.min(r - 1, n - 2);

                if (l > r)
                    ans.add(0);
                else
                    ans.add(ft.rangeQuery(l, r));

            } else {

                int idx = q[1];
                nums[idx] = q[2];

                for (int i = Math.max(1, idx - 1); i <= Math.min(n - 2, idx + 1); i++) {

                    boolean cur = isPeak(nums, i);

                    if (cur != peak[i]) {
                        peak[i] = cur;
                        ft.update(i, cur ? 1 : -1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 4, 2, 1, 5};

        int[][] queries = {
                {2, 2, 4},
                {1, 0, 2},
                {1, 0, 4}
        };

        List<Integer> ans = countOfPeaks(nums, queries);

        System.out.println(ans);
    }
}