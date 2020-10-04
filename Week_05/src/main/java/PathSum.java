import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {
    /**
     * 树节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 用于保存路径
     */
    private Deque<Integer> path = new ArrayDeque<>();
    /**
     * 结果
     */
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    /**
     * 深度遍历加回溯
     * @param root 树的根节点
     * @param sum  目标和
     */
    private void dfs(TreeNode root, int sum) {
        if (root != null) {
            path.addLast(root.val);
            sum -= root.val;
            if(root.left == null && root.right == null && sum == 0){
                ret.add(new ArrayList<>(path));
            }
            dfs(root.left,sum);
            dfs(root.right,sum);
            path.removeLast();
        }
    }


}
