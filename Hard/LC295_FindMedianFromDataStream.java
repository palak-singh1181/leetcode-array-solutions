import java.util.*;

public class LC295_FindMedianFromDataStream {

    static class MedianFinder {

        // Max Heap
        PriorityQueue<Integer> left;

        // Min Heap
        PriorityQueue<Integer> right;

        public MedianFinder() {

            left = new PriorityQueue<>(Collections.reverseOrder());

            right = new PriorityQueue<>();
        }

        public void addNum(int num) {

            // Step 1: Add to left heap
            left.add(num);

            // Step 2: Make sure every left element
            // is <= every right element
            if (!right.isEmpty() && left.peek() > right.peek()) {

                int value = left.poll();

                right.add(value);
            }

            // Step 3: Balance sizes
            if (left.size() > right.size() + 1) {

                right.add(left.poll());

            } else if (right.size() > left.size()) {

                left.add(right.poll());
            }
        }

        public double findMedian() {

            // Odd number of elements
            if (left.size() > right.size()) {

                return left.peek();
            }

            // Even number of elements
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);

        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
    }
}