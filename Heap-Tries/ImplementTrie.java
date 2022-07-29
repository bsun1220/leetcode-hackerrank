public class ImplementTrie {
    Set<String> prefixes;
    Set<String> words;
    public Trie() {
        prefixes = new HashSet<>();
        words = new HashSet<>();
    }

    public void insert(String word) {
        words.add(word);
        for(int i = 1; i <= word.length(); i++){
            prefixes.add(word.substring(0, i));
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        return prefixes.contains(prefix);
    }
}
