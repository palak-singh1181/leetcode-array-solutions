
import java.util.*;

// LeetCode 284 - Peeking Iterator

public class LC284_PeekingIterator {

    static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer peekValue;
        private boolean hasPeeked;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            this.hasPeeked = false;
        }

        public Integer peek() {

            if (!hasPeeked) {
                peekValue = iterator.next();
                hasPeeked = true;
            }

            return peekValue;
        }

        @Override
        public Integer next() {

            if (hasPeeked) {
                Integer value = peekValue;
                hasPeeked = false;
                peekValue = null;
                return value;
            }

            return iterator.next();
        }

        @Override
        public boolean hasNext() {

            return hasPeeked || iterator.hasNext();
        }
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3);

        PeekingIterator peekingIterator =
                new PeekingIterator(nums.iterator());

        System.out.println("next(): " + peekingIterator.next());
        System.out.println("peek(): " + peekingIterator.peek());
        System.out.println("next(): " + peekingIterator.next());
        System.out.println("next(): " + peekingIterator.next());
        System.out.println("hasNext(): " + peekingIterator.hasNext());
    }
}