/**
 * 寻找最近的共同祖先节点
 * 关键是判断条件
 */
public class LowestCommonAncestorSolution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //结果
    private TreeNode ans;

    /**
     * 1.p、q分别在左右子树
     * 2.p=root 且 q在左子树或者右子树中
     * 3.q=root 且 p在左子树或者右子树中
     * @param root 根节点
     * @param p p
     * @param q q
     * @return 最近的祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        terminator
        if (root == null || root == p || root == q){
            return root;
        }
//        drill down
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        process logic in current level
        if (left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
