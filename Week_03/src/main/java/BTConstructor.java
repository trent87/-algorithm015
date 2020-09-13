/**
 * 二叉树的构造器
 * 从前序与中序遍历构造二叉树
 */
public class BTConstructor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0, preorder.length, 0, inorder.length);
    }

    TreeNode helper(int[] preorder,int[] inorder,int pStart,int pEnd,int iStart,int iEnd){
        if (pStart >= pEnd){
            return null;
        }
        //前序遍历的第一个节点是根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int iOrderRoot = 0;
        //确定中序遍历的根节点下标
        for (int i = iStart ; i < iEnd;i++){
            if(rootVal == inorder[i]){
                iOrderRoot = i;
                break;
            }
        }
        //根据中序遍历结果和中序遍历的根节点下标，确定左子树的元素个数
        int leftCount = iOrderRoot - iStart;
        // 前序遍历右子树的结束下标
        int pRightStart = pStart + leftCount + 1;
        //递归左子树
        root.left = helper(preorder,inorder,pStart + 1,pRightStart ,iStart,iOrderRoot);
        //递归右子树
        root.right = helper(preorder,inorder,pRightStart,pEnd,iOrderRoot + 1,iEnd);
        return root;
    }

    public static void main(String[] args){
        BTConstructor btConstructor = new BTConstructor();
        int[] pre = new int []{3,9,20,15,7};
        int[] in = new int []{9,3,15,20,7};
        TreeNode root = btConstructor.buildTree(pre,in);
    }
}
