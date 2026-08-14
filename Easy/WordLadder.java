import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;
                        String next = new String(arr);

                        if (next.equals(endWord))
                            return level + 1;

                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}