
public class WordDictionary {

    static class Node {

        Node[] children = new Node[26];
        boolean isEnd;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node current) {

        // Word completely checked
        if (index == word.length()) {
            return current.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            int i = ch - 'a';

            if (current.children[i] == null) {
                return false;
            }

            return searchHelper(
                word,
                index + 1,
                current.children[i]
            );
        }

        // '.' can represent any character
        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                if (searchHelper(
                    word,
                    index + 1,
                    current.children[i]
                )) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}