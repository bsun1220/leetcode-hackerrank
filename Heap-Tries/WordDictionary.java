public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node iter = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(iter.children[c - 'a'] == null){
                iter.children[c - 'a'] = new Node();
                iter.check.add(c);
            }
            iter = iter.children[c - 'a'];
        }
        iter.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    public boolean dfs(String word, Node node){
        if(node == null){
            return false;
        }
        if(word.equals("")){
            return node.isWord;
        }

        boolean result = false;
        char val = word.charAt(0);

        if(val == '.'){
            for(Character c : node.check){
                result = result || dfs(word.substring(1), node.children[c - 'a']);
            }
        }

        else{
            result = result || dfs(word.substring(1), node.children[val - 'a']);
        }

        return result;

    }
}
