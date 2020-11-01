import java.util.ArrayDeque;
import java.util.Deque;

public class SumRootToLeafNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumNumbers(TreeNode root) {
        Deque<Integer> stack = new ArrayDeque<>();
        resLeft(root,stack);
        StringBuilder left = new StringBuilder();
        while(!stack.isEmpty()){
            left.append(stack.poll());
        }
        resRight(root,stack);
        StringBuilder right = new StringBuilder();
        while(!stack.isEmpty()){
            right.append(stack.poll());
        }
        return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
    }

    private void resLeft (TreeNode root,Deque<Integer> stack){
        if(root == null){
            return;
        }
        stack.addLast(root.val);
        resLeft(root.left,stack);
    }

    private void resRight(TreeNode root,Deque<Integer> stack){
        if(root == null){
            return;
        }
        stack.addLast(root.val);
        resRight(root.right,stack);
    }

}
