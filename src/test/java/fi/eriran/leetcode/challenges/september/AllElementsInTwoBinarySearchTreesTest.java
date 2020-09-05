package fi.eriran.leetcode.challenges.september;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class AllElementsInTwoBinarySearchTreesTest {

    @Test
    void example1() {
        TreeNode first = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{2, 1, 4});
        TreeNode second = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{1, 0, 3});

        List<Integer> resultArray = new AllElementsInTwoBinarySearchTrees().getAllElements(first, second);
        assertThat(resultArray, contains(Arrays.asList(0, 1, 1, 2, 3, 4)));
    }

    @Test
    void example2() {
        TreeNode first = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{0, -10, 10});
        TreeNode second = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{5, 1, 7, 0, 2});

        List<Integer> resultArray = new AllElementsInTwoBinarySearchTrees().getAllElements(first, second);
        assertThat(resultArray, contains(Arrays.asList(-10, 0, 0, 1, 2, 5, 7, 10)));
    }

    @Test
    void example3() {
        TreeNode first = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{});
        TreeNode second = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{5, 1, 7, 0, 2});

        List<Integer> resultArray = new AllElementsInTwoBinarySearchTrees().getAllElements(first, second);
        assertThat(resultArray, contains(Arrays.asList(0, 1, 2, 5, 7)));
    }

    @Test
    void example4() {
        TreeNode first = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{0, -10, 10});
        TreeNode second = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{});

        List<Integer> resultArray = new AllElementsInTwoBinarySearchTrees().getAllElements(first, second);
        assertThat(resultArray, contains(Arrays.asList(-10, 0, 10)));
    }

    @Test
    void example5() {
        TreeNode first = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{1, null, 8});
        TreeNode second = TreeNodeTestUtil.createBinarySearchTree(new Integer[]{8, 1});

        List<Integer> resultArray = new AllElementsInTwoBinarySearchTrees().getAllElements(first, second);
        assertThat(resultArray, contains(Arrays.asList(1, 1, 8, 8)));
    }
}