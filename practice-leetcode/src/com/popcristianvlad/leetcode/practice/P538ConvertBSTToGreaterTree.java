package com.popcristianvlad.leetcode.practice;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class P538ConvertBSTToGreaterTree {

    private static int currentSum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);

        root.val += currentSum;
        currentSum = root.val;

        convertBST(root.left);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                4,
                new TreeNode(
                        1,
                        new TreeNode(
                                0
                        ),
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        3
                                )
                        )
                ),
                new TreeNode(
                        6,
                        new TreeNode(
                                5
                        ),
                        new TreeNode(
                                7,
                                null,
                                new TreeNode(
                                        8
                                )
                        )
                )
        );

        TreeNode greaterTree = convertBST(treeNode);
        System.out.println();
    }
}
