
import java.util.*;

public class HIndex {

    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};

        int h = 0;

        for (int i = 1; i <= citations.length; i++) {

            int count = 0;

            for (int j = 0; j < citations.length; j++) {

                if (citations[j] >= i) {
                    count++;
                }
            }

            if (count >= i) {
                h = i;
            }
        }

        System.out.println("H-Index = " + h);
    }
}