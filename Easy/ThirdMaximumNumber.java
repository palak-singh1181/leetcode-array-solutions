public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            long n = num;

            // Ignore duplicate values
            if ((first != null && n == first) ||
                (second != null && n == second) ||
                (third != null && n == third)) {
                continue;
            }

            // Largest
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            }

            // Second largest
            else if (second == null || n > second) {
                third = second;
                second = n;
            }

            // Third largest
            else if (third == null || n > third) {
                third = n;
            }
        }

        if (third == null) {
            return first.intValue();
        }

        return third.intValue();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 1};

        int answer = thirdMax(nums);

        System.out.println(answer);
    }
}