package pl.tw.random;

import pl.tw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        var root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(
                                4,
                                new TreeNode(
                                        8,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        9,
                                        null,
                                        null
                                )
                        ),
                        new TreeNode(
                                5,
                                new TreeNode(
                                        10,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        11,
                                        null,
                                        null
                                )
                        )
                ),
                new TreeNode(
                        3,
                        new TreeNode(
                                6,
                                new TreeNode(
                                        12,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        13,
                                        null,
                                        null
                                )
                        ),
                        new TreeNode(
                                7,
                                new TreeNode(
                                        14,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        15,
                                        null,
                                        null
                                )
                        )
                )
        );
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            System.out.println(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }
}
