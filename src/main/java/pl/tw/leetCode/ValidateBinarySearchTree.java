package pl.tw.leetCode;

import pl.tw.random.datastructures.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
