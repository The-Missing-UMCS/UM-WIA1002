package com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q6;

public class Main {
    public static void main(String[] args) {
        // 6a: Tree Traversals
        TreeNode root = createSampleTree();

        System.out.println("# In-order: ");
        inOrderTraversal(root);

        System.out.println("\n\n# Pre-order: ");
        preOrderTraversal(root);

        System.out.println("\n\n# Post-order: ");
        postOrderTraversal(root);

        TreeNode copiedRoot1 = deepCopy(root);
        TreeNode copiedRoot2 = deepCopy(root);

        int[] nodesToDelete = { 12, 34, 66 };
        deleteNodes(copiedRoot1, nodesToDelete);
        System.out.println("\n\n# (1) In-order after deleting 12, 34, 66");
        inOrderTraversal(copiedRoot1);

        deleteNodes(copiedRoot2, nodesToDelete);
        System.out.println("\n\n# (2) In-order after deleting 12, 34, 66");
        inOrderTraversal(copiedRoot2);

        System.out.println("\n\n# Conversion to CDLL");
        BSTToCDLL converter = new BSTToCDLL();
        converter.bstToCdll(root);
        converter.makeCircular();
        converter.printCircularDll();
    }

    private static TreeNode createSampleTree() {
        TreeNode node12 = new TreeNode(12, null, new TreeNode(18));
        TreeNode node31 = new TreeNode(31, new TreeNode(29), new TreeNode(33));
        TreeNode node36 = new TreeNode(36, null, new TreeNode(40, new TreeNode(38), null));
        TreeNode node66 = new TreeNode(66, new TreeNode(64), new TreeNode(100, new TreeNode(99), null));
        TreeNode node27 = new TreeNode(27, node12, node31);
        TreeNode node56 = new TreeNode(56, node36, node66);
        return new TreeNode(34, node27, node56);
    }

    private static void deleteNodes(TreeNode root, int[] targets) {
        for (int target : targets) {
            deleteNode(root, target);
        }
    }

    // Method in
    // https://github.com/fyiernzy/UM-WIA1002/blob/main/Lab/Version1/Lab12%20-%20Tree/BST/BST.java
    // contains unnecessary steps.
    // Specifically, when the left child is not null, it immediately finds the
    // rightmost node of the left child. However, if the right child is null,
    // it can directly replace itself with the left child.
    // The deleteNode method fixes this issue.
    public static void deleteNode(TreeNode root, int target) {
        // Find the target node and its parent
        TreeNode parent = null;
        TreeNode current = root;

        while (current != null && current.value != target) {
            parent = current;
            current = current.value > target ? current.left : current.right;
        }

        // The target node doesn't exist
        if (current == null)
            return;

        // If the node to be deleted has at most one child
        if (current.right == null || current.left == null) {
            TreeNode child = (current.left != null) ? current.left : current.right;
            if (parent == null) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // Node to be deleted has two children
            TreeNode successorParent = current;
            TreeNode successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.value = successor.value;
            if (successorParent.right == successor) {
                successorParent.right = successor.left;
            } else {
                successorParent.left = successor.left;
            }
        }
    }

    public static void deleteOld(TreeNode root, int target) {
        // Find the target node and its parent
        TreeNode parent = null;
        TreeNode current = root;

        while (current != null && current.value != target) {
            parent = current;
            current = current.value > target ? current.left : current.right;
        }

        // The target node doesn't exist
        if (current == null)
            return;

        // If the node to be deleted has at most one child
        if (current.right == null || current.left == null) {
            TreeNode child = (current.left != null) ? current.left : current.right;
            if (parent == null) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // Node to be deleted has two children
            TreeNode successorParent = current;
            TreeNode successor = current.left;
            while (successor.right != null) {
                successorParent = successor;
                successor = successor.right;
            }
            current.value = successor.value;
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
    }

    public static TreeNode deepCopy(TreeNode root) {
        if (root == null)
            return null;
        TreeNode copy = new TreeNode(root.value);
        copy.left = deepCopy(root.left);
        copy.right = deepCopy(root.right);
        return copy;
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }
}
