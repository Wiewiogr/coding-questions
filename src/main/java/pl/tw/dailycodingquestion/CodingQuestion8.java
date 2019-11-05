package pl.tw.dailycodingquestion;

import pl.tw.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * <p>
 * Given the root to a binary tree, count the number of unival subtrees.
 * <p>
 * For example, the following tree has 5 unival subtrees:
 * <p>
 * ....0
 * ../ \
 * .1   0
 * ..../ \
 * ...1   0
 * ../ \
 * .1   1
 */
public class CodingQuestion8 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                0,
                new TreeNode(
                        1,
                        null,
                        null
                ),
                new TreeNode(
                        0,
                        new TreeNode(
                                1,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                )
                        ),
                        new TreeNode(
                                0,
                                null,
                                null
                        )
                )
        );

        var result = new AtomicInteger();
        isUnival(treeNode, result);
        System.out.println(result);
    }

    public static boolean isUnival(TreeNode node, AtomicInteger result) {


        boolean isUnival = true;
        if (node.left != null) {
            if (!isUnival(node.left, result)) {
                isUnival = false;
            } else {
                if (node.left.val != node.val) {
                    isUnival = false;
                }
            }
        }

        if (node.right != null) {
            if (!isUnival(node.right, result)) {
                isUnival = false;
            } else {
                if (node.right.val != node.val) {
                    isUnival = false;
                }
            }
        }

        if (isUnival) {
            result.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }
}
