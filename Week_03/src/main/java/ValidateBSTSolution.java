import java.util.ArrayList;
import java.util.List;

public class ValidateBSTSolution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    long pre = Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = Long.parseLong(Integer.toString(root.val));
        return isValidBST(root.right);
    }
}
