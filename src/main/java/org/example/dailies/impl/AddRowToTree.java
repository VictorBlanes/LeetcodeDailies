package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;
import org.example.dailies.util.TreeNodeUtils;
import org.example.models.TreeNode;

import java.util.Arrays;

import static org.example.dailies.util.Constants.RED_TEXT;
import static org.example.dailies.util.Constants.RESET;

public class AddRowToTree extends DailyProblemBase {
    @Override
    public void start() {
        TreeNodeUtils treeNodeUtils = new TreeNodeUtils();
        TreeNode dat1 = treeNodeUtils.createTreeFromArray(new Integer[]{4, 2, 6, 3, 1, 5});
        TreeNode dat2 = treeNodeUtils.createTreeFromArray(new Integer[]{4, 2, null, 3, 1});
        TreeNode[] data = {dat1, dat2};
        int[] data1 = {1, 1};
        int[] data2 = {2, 3};
        TreeNode ex1 = treeNodeUtils.createTreeFromArray(new Integer[]{4, 1, 1, 2, null, null, 6, 3, 1, 5});
        TreeNode ex2 = treeNodeUtils.createTreeFromArray(new Integer[]{4, 2, null, 1, 1, 3, null, null, 1});
        TreeNode[] expected = {ex1, ex2};
        System.out.print("\nDay 23 Number 623 - Add One Row to Tree\n");
        System.out.print(RED_TEXT + "El treeNodeUtils no funciona bien btw\n" + RESET);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i,
                    Arrays.toString(treeNodeUtils.returnTreeData(expected[i])),
                    Arrays.toString(treeNodeUtils.returnTreeData(addOneRow(data[i], data1[i], data2[i]))));
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return adder(root, val, depth);
    }

    private TreeNode adder(TreeNode node, int val, int depth) {
        if (depth == 2) {
            TreeNode newNodeLeft = new TreeNode(val);
            newNodeLeft.setLeft(node.getLeft());
            TreeNode newNodeRight = new TreeNode(val);
            newNodeRight.setRight(node.getRight());
            node.setLeft(newNodeLeft);
            node.setRight(newNodeRight);
            return node;
        } else if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.setLeft(node);
            return newNode;
        } else {
            if (node.getLeft() != null) {
                adder(node.getLeft(), val, depth - 1);
            }

            if (node.getRight() != null) {
                adder(node.getRight(), val, depth - 1);
            }

            return node;

        }
    }
}
