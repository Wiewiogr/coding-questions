package pl.tw.dailycodingquestion.num21to30;

/**
 * This problem was asked by Google.
 * <p>
 * Implement locking in a binary tree.
 * A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
 * <p>
 * Design a binary tree node class with the following methods:
 * <p>
 * is_locked, which returns whether the node is locked
 * <p>
 * lock, which attempts to lock the node. If it cannot be locked,
 * then it should return false. Otherwise, it should lock it and return true.
 * <p>
 * unlock, which unlocks the node. If it cannot be unlocked, then it should return false.
 * Otherwise, it should unlock it and return true.
 * <p>
 * You may augment the node to add parent pointers or any other property you would like.
 * You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 * Each method should run in O(h), where h is the height of the tree.
 */
public class CodingQuestion24 {

    public static void main(String[] args) {
        LockableNode root = new LockableNode();

        root.left = new LockableNode();
        root.left.parent = root;

        root.right = new LockableNode();
        root.right.parent = root;

        root.right.right = new LockableNode();
        root.right.right.parent = root.right;

        root.right.left = new LockableNode();
        root.right.left.parent = root.right;

        root.right.left.left = new LockableNode();
        root.right.left.left.parent = root.right.left;

        root.right.left.right = new LockableNode();
        root.right.left.right.parent = root.right.left;

        root.right.left.right.right = new LockableNode();
        root.right.left.right.right.parent = root.right.left.right;

        System.out.println(root.right.right.lock()); // true
        System.out.println(root.right.right.isLocked()); // true
        System.out.println(root.lock()); // false
        System.out.println(root.right.left.right.lock()); // true
        System.out.println(root.right.left.left.lock()); // true
        System.out.println(root.right.left.lock()); // false
    }

    public static class LockableNode {

        public int val;
        public LockableNode left;
        public LockableNode right;
        public LockableNode parent;

        private boolean isLocked;
        private int lockedDescendantsCount;

        public boolean isLocked() {
            return isLocked;
        }

        public boolean lock() {
            if (lockedDescendantsCount > 0) {
                return false;
            }

            LockableNode cur = parent;
            while (cur != null) {
                if (cur.isLocked) {
                    return false;
                }
                cur = cur.parent;
            }

            isLocked = true;
            cur = parent;
            while (cur != null) {
                cur.lockedDescendantsCount++;
                cur = cur.parent;
            }
            return true;
        }

        public boolean unlock() {
            isLocked = false;
            LockableNode cur = parent;
            while (cur != null) {
                cur.lockedDescendantsCount--;
                cur = cur.parent;
            }
            return true;
        }
    }
}
