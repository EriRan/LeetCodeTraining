package fi.eriran.leetcode.challenges.september;

public class TreeNodeTestUtil {

    private TreeNodeTestUtil() {
    }

    public static TreeNode createBinarySearchTree(Integer[] ints) {
        if (ints == null || ints.length == 0) {
            return new TreeNode();
        }
        TreeNode root = new TreeNode(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            Integer currentNumber = ints[i];
            if (currentNumber == null) {
                continue;
            }
            placeNode(root, currentNumber);
        }
        return root;
    }

    private static void placeNode(TreeNode currentNode, int number) {
        switch (Integer.compare(currentNode.val, number)) {
            case 1:
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(number);
                } else {
                    placeNode(currentNode.left, number);
                }
                break;
            case -1:
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(number);
                } else {
                    placeNode(currentNode.right, number);
                }
                break;
            case 0:
                throw new IllegalArgumentException("Duplicates now allowed");
            default:
                throw new IllegalStateException("Unknown result from number comparison");
        }
    }
}
