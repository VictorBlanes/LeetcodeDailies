package org.example.dailies.impl;

import com.sun.source.tree.Tree;
import org.example.dailies.DailyProblemBase;
import org.example.models.TreeNode;

import static java.util.Objects.nonNull;

public class SumRootLeftNumbers extends DailyProblemBase {
    @Override
    public void start() {
        TreeNode ex1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode ex2 = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        TreeNode[] data = {ex1, ex2};
        int[] expected = {25, 1026};
        System.out.print("\nDay 21 Number 129 - Sum Root to Leaf Numbers\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], sumNumbers(data[i]));
        }
    }

    private int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }

    private static int getSum(TreeNode root, int num) {
        int resLeft = nonNull(root.getLeft()) ? getSum(root.getLeft(), (num * 10) + root.getVal()) : 0;
        int resRight = nonNull(root.getRight()) ? getSum(root.getRight(), (num * 10) + root.getVal()) : 0;
        return resLeft == 0 && resRight == 0 ? (num * 10) + root.getVal() : resLeft + resRight;
    }
}
