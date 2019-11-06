package pl.tw.random.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private final Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                Node newNode = new Node();
                current.children.put(c, newNode);
                current = newNode;
            }
        }
        current.isTerminal = true;
    }

    public List<String> autoComplete(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return List.of();
            }
        }

        List<String> results = new ArrayList<>();
        traverse(current, prefix, results);
        return results;
    }

    private void traverse(Node current, String prefix, List<String> results) {
        if (current.isTerminal) {
            results.add(prefix);
        }

        current.children.forEach((key, val) -> traverse(val, prefix + key, results));
    }

    public List<String> getAll() {
        List<String> results = new ArrayList<>();
        traverse(root, "", results);
        return results;
    }

    private static class Node {

        public HashMap<Character, Node> children = new HashMap<>();
        public boolean isTerminal = false;
    }
}
