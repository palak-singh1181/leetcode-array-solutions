import java.util.*;

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord,
                                                 String endWord,
                                                 List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return ans;

        Map<String, List<String>> parent = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[j] = c;

                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }

                            parent.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    arr[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (!found)
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, ans);

        return ans;
    }

    private static void dfs(String word,
                            String beginWord,
                            Map<String, List<String>> parent,
                            List<String> path,
                            List<List<String>> ans) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if (!parent.containsKey(word))
            return;

        for (String prev : parent.get(word)) {

            path.add(prev);
            dfs(prev, beginWord, parent, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> ans = findLadders(beginWord, endWord, wordList);

        System.out.println(ans);
    }
}