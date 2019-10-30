package pl.tw.dailycodingquestion;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */
public class CodingQuestion3 {

    public static void main(String[] args) {
        var root = new Node(
                1,
                new Node(
                        2,
                        new Node(
                                4,
                                null,
                                null
                        ),
                        null
                ),
                new Node(
                        3,
                        null,
                        new Node(
                                7,
                                null,
                                null
                        )
                )
        );
        System.out.println(root);
        System.out.println(deserializeTree(serializeTree(root)));
    }

    public static int[] serializeTree(Node tree) {
        int[] array = new int[100];
        serialize(tree, 0, array);
        return array;
    }

    public static void serialize(Node node, int index, int[] array) {
        array[index] = node.val;

        if (node.left != null) {
            serialize(node.left, index * 2 + 1, array);
        }

        if (node.right != null) {
            serialize(node.right, index * 2 + 2, array);
        }
    }

    public static Node deserializeTree(int[] array) {
        Node root = new Node();
        deserialize(root, 0, array);
        return root;
    }

    public static Node deserialize(Node node, int index, int[] array) {
        node.val = array[index];

        if (array[index * 2 + 1] != 0) {
            node.left = deserialize(new Node(), index * 2 + 1, array);
        }

        if (array[index * 2 + 2] != 0) {
            node.right = deserialize(new Node(), index * 2 + 2, array);
        }
        return node;
    }

    public static class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "( " + left + " " + val + " " + right + " )";
        }
    }
}
