package org.example.dailies.impl;

import org.example.dailies.DailyProblemBase;
import org.example.models.TreeNode;

public class SmallestStringFromLeaf extends DailyProblemBase {
    @Override
    public void start() {
        TreeNode dat1 = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        TreeNode dat2 = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)));
        TreeNode dat3 = new TreeNode(2, new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)), new TreeNode(1, new TreeNode(0), null));
        TreeNode dat4 = new TreeNode(3, new TreeNode(2, new TreeNode(9), null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode[] data = {dat1, dat2, dat3, dat4};
        String[] expected = {"dba", "adz", "abc", "hud"};
        System.out.print("\nDay 24 Number 988 - Smallest String From Leaf\n");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Dataset Nº: %d\t Result expected: %s\t Result received: %s\n", i, expected[i], smallestFromLeaf(data[i]));
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        return getSmallest(root, "", "*");
    }

    private String getSmallest(TreeNode root, String current, String smallest) {
        current = (char) (root.getVal() + 97) + current;
        if (root.getLeft() == null && root.getRight() == null) {
            if (smallest.equals("*")) {
                return current;
            } else {
                return returnSmallestString(current, smallest);
            }
        } else {
            String smallestLeft = null;
            String smallestRight = null;

            if (root.getLeft() != null) {
                smallestLeft = getSmallest(root.getLeft(), current, smallest);
            }

            if (root.getRight() != null) {
                smallestRight = getSmallest(root.getRight(), current, smallest);
            }

            if (smallestLeft == null) {
                return smallestRight;
            } else if (smallestRight == null) {
                return smallestLeft;
            } else {
                return returnSmallestString(smallestLeft, smallestRight);
            }
        }
    }

    private String returnSmallestString(String left, String right) {
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            if ((int) left.charAt(i) < (int) right.charAt(i)) {
                return left;
            } else if ((int) left.charAt(i) > (int) right.charAt(i)) {
                return right;
            }
        }
        return left.length() < right.length() ? left : right;
    }
}
