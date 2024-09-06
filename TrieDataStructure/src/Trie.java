public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();//root is empty

    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }

        }
        current.isWord = true;


    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) {
                return false; // If the character is not found, the word is not present
            } else {
                current = current.children[index];
            }
        }
        return current.isWord; // Return true if current node marks the end of the word
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        prefix = prefix.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) {
                return false; // If the character is not found, no word starts with the prefix
            } else {
                current = current.children[index];
            }
        }
        return true; // Return true if all characters in the prefix are found
    }

    public void printWords() {
        printWordsHelper(root, "");
    }

    private void printWordsHelper(TrieNode current, String word) {
        if (current.isWord) {
            System.out.println(word); // Print the word when a complete word is found
        }

        // Traverse all possible child nodes (a to z)
        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null) {
                char c = (char) (i + 'a'); // Convert index back to character
                printWordsHelper(current.children[i], word + c); // Recursive call
            }
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");

        System.out.println("Values inserted succesfully");
        trie.printWords();
    }
}
