package pl.tw.leetCode;

import pl.tw.random.datastructures.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return visit(root);
    }

    private int visit(TreeNode node) {
        if(node == null) return 0;

        int leftDepth = visit(node.left);
        int rightDepth = visit(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
