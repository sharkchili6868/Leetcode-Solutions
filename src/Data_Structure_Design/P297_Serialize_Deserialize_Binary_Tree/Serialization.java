package Data_Structure_Design.P297_Serialize_Deserialize_Binary_Tree;

import _utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Serialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return preorder(root, sb);
    }

    private String preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N").append(" ");
        } else {
            sb.append(root.val).append(" ");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, values);
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String val = queue.poll();
        if (val.equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}
