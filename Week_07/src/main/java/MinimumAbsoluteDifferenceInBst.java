public class MinimumAbsoluteDifferenceInBst {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre,min;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }


}
