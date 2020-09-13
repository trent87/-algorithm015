public class TreeMaxLevelSolution {

    private int maxLevel;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftMaxLevel = maxDepth(root.left);
        int rightMaxLevel = maxDepth(root.right);
        return Math.max(leftMaxLevel,rightMaxLevel) + 1;
    }

}
