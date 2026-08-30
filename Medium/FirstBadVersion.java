
public class FirstBadVersion {

    // Testing ke liye maan lo version 4 se bad hai
    static int badVersion = 4;

    public static boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid bad hai
                // first bad mid ya usse pehle ho sakta hai
                right = mid;
            } 
            else {
                // mid good hai
                // first bad mid ke baad hoga
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int n = 5;

        int answer = firstBadVersion(n);

        System.out.println("First Bad Version = " + answer);
    }
}