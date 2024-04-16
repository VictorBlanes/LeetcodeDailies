package org.example.dailies.util;

import lombok.NoArgsConstructor;
import org.example.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TreeNodeUtils {
    //TODO: Arreglar
    public TreeNode createTreeFromArray(Integer[] valData) {
        List<TreeNode> toTreat = new ArrayList<>();

        if (valData == null || valData.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(valData[0]);
        toTreat.add(root);

        for (int i = 1; i < valData.length; i++) {
            TreeNode treating = toTreat.get(0);
            TreeNode node;
            if (valData[i] != null) {
                node = new TreeNode(valData[i]);
            } else {
                node = null;
            }

            if (treating.getLeft() == null) {
                treating.setLeft(node);
            } else {
                treating.setRight(node);
                toTreat.remove(0);
            }

            if (node != null) {
                toTreat.add(node);
            }
        }

        return root;
    }

    public Integer[] returnTreeData(TreeNode root) {
        List<Integer> treeData = new ArrayList<>();
        if (root == null) {
            return new Integer[] {null};
        }

        List<TreeNode> toTreat = new ArrayList<>();
        toTreat.add(root);
        while (!toTreat.isEmpty()) {
            TreeNode node = toTreat.get(0);

            if (node != null) {
                treeData.add(node.getVal());
                toTreat.add(node.getLeft());
                toTreat.add(node.getRight());
            } else {
                treeData.add(null);
            }

            toTreat.remove(0);
        }
        return treeData.toArray(Integer[]::new);
    }
}
