package fi.eriran.leetcode.challenges.september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Return a list containing all the integers from both trees sorted in ascending order.
 */
public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return new ArrayList<>();
        }
        return returnInAscendingOrder(root1, root2);
    }

    private List<Integer> returnInAscendingOrder(TreeNode root1, TreeNode root2) {
        return combineAndSort(
                turnIntoList(root1),
                turnIntoList(root2)
        );
    }

    private List<Integer> combineAndSort(List<Integer> root1List, List<Integer> root2List) {
        List<Integer> combinedArrays = new ArrayList<>();
        combinedArrays.addAll(root1List);
        combinedArrays.addAll(root2List);
        Collections.sort(combinedArrays);
        return combinedArrays;
    }

    private List<Integer> turnIntoList(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> nodeList = new ArrayList<>();
        findNextNumber(root, nodeList);
        return nodeList;
    }

    private void findNextNumber(TreeNode root, List<Integer> nodeList) {
        if (root.left != null) {
            findNextNumber(root.left, nodeList);
        }
        nodeList.add(root.val);
        if (root.right != null) {
            findNextNumber(root.right, nodeList);
        }
    }
}
