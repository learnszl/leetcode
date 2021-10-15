package codetop;


/**
 * @Author szl
 * @Date 2021/9/17 11:19
 * @Description
 */
public class Trie {
    static class TrieNode {

        // R links to node children
        private final TrieNode[] links;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26];
        }

//        public boolean containsKey(char ch) {
//            return links[ch - 'a'] != null;
//        }
//
//        public TrieNode get(char ch) {
//            return links[ch - 'a'];
//        }
//
//        public void put(char ch, TrieNode node) {
//            links[ch - 'a'] = node;
//        }
//
//        public void setEnd() {
//            isEnd = true;
//        }
//
//        public boolean isEnd() {
//            return isEnd;
//        }
    }

    //    static class TrieNode {
//        TrieNode next;
//        boolean isEnd;
//        TrieNode[] children;
//
//        TrieNode() {
//            children = new TrieNode[26];
//            isEnd = false;
//        }
//    }
//
//    private TrieNode root;
    private final TrieNode root;


    /**
     * Initialize your data structure here.
     */

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.links[currentChar - 'a'] == null) {
                node.links[currentChar - 'a'] =  new TrieNode();
            }
            node = node.links[currentChar - 'a'];
        }
       node.isEnd = true;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.links[curLetter - 'a'] != null) {
                node = node.links[curLetter - 'a'];
            } else {
                return null;
            }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
    }
}
