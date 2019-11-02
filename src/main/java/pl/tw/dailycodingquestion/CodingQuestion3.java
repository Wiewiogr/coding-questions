package pl.tw.dailycodingquestion;

import pl.tw.TreeNode;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */
public class CodingQuestion3 {

    public static void main(String[] args) {
        var root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(
                                4,
                                null,
                                null
                        ),
                        null
                ),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(
                                7,
                                null,
                                null
                        )
                )
        );
        System.out.println(root);
        System.out.println(deserializeTree(serializeTree(root)));
    }

    public static int[] serializeTree(TreeNode tree) {
        int[] array = new int[100];
        serialize(tree, 0, array);
        return array;
    }

    public static void serialize(TreeNode node, int index, int[] array) {
        array[index] = node.val;

        if (node.left != null) {
            serialize(node.left, index * 2 + 1, array);
        }

        if (node.right != null) {
            serialize(node.right, index * 2 + 2, array);
        }
    }

    public static TreeNode deserializeTree(int[] array) {
        TreeNode root = new TreeNode();
        deserialize(root, 0, array);
        return root;
    }

    public static TreeNode deserialize(TreeNode node, int index, int[] array) {
        node.val = array[index];

        if (array[index * 2 + 1] != 0) {
            node.left = deserialize(new TreeNode(), index * 2 + 1, array);
        }

        if (array[index * 2 + 2] != 0) {
            node.right = deserialize(new TreeNode(), index * 2 + 2, array);
        }
        return node;
    }
}
