package everyday;

/**
 * @Author szl
 * @Date 2021/10/19 16:33
 * @Description
 */
public class p1019 {
    static class TreeNode {
        private TreeNode[] links;
        private boolean isEnd;

        TreeNode() {
            links = new TreeNode[26];
        }
    }

    private TreeNode root;

    public p1019() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (node.links[curr - 'a'] == null) {
                node.links[curr - 'a'] = new TreeNode();
            }
            node = node.links[curr - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TreeNode node) {
        if (index == word.length())
            return node.isEnd;
        char curr = word.charAt(index);
        if (curr == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null && dfs(word, index + 1, node.links[i])) {
                    return true;
                }
            }
        } else {
            return node.links[curr - 'a'] != null && dfs(word, index + 1, node.links[curr - 'a']);
        }
        return false;
    }
}
