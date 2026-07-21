import java.util.Arrays;

public class DecodeXORedArray {

    public static int[] decode(int[] encoded, int first) {

        int[] arr = new int[encoded.length + 1];

        arr[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] encoded = {1, 2, 3};
        int first = 1;

        System.out.println("Encoded Array : " + Arrays.toString(encoded));
        System.out.println("First Element : " + first);

        int[] result = decode(encoded, first);

        System.out.println("Decoded Array : " + Arrays.toString(result));
    }
}