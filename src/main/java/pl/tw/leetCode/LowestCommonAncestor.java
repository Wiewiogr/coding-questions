package pl.tw.leetCode;

import pl.tw.random.datastructures.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return visit(root, p.val, q.val);
    }

    private TreeNode visit(TreeNode node, int p, int q) {
        if (node.val == p || node.val == q) {
            return node;
        }

        if ((node.val > p && node.val < q) || (node.val < p && node.val > q)) {
            return node;
        }

        if ((node.val > p && node.val > q)) {
            return visit(node.left, p, q);
        } else {
            return visit(node.right, p, q);
        }
    }
}
