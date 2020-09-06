package com.trent.algorithm;

import com.trent.commons.TreeNode;

/**
 * 二叉树遍历算法
 */
public class BinaryTreeTraversal {


    /**
     * 对二叉树进行前序遍历（根-左-右）并返遍历结果的字符串
     *
     * @param treeNode 二叉树的根节点
     * @return 输出的二叉树数据
     */
    public String preOrderTraversal(TreeNode treeNode) {
        StringBuilder output = new StringBuilder();
        recurPreOrderTraversal(treeNode, output, true);
        return output.toString();
    }

    /**
     * 对二叉树进行中序遍历（左-根-右）并返回遍历结果的字符串
     * @param treeNode 二叉树的根节点
     * @return 输出的二叉树数据
     */
    public String inOrderTraversal(TreeNode treeNode) {
        StringBuilder output = new StringBuilder();
        recurInOrderTraversal(treeNode,output,true);
        return output.toString();
    }

    /**
     * 通过递归实现二叉树的前序遍历
     *
     * @param parent 父节点
     * @param output 输出的字符串
     * @param start  是否是根节点
     */
    private void recurPreOrderTraversal(TreeNode parent, StringBuilder output, boolean start) {
        int value = parent.getVal();
        if (!start) {
            output.append(",");
        }
        if (value != -1) {
            output.append(value);
            TreeNode leftChild = parent.getLeft();
            TreeNode rightChild = parent.getRight();
            if (leftChild != null) {
                recurPreOrderTraversal(leftChild, output, false);
            }
            if (rightChild != null) {
                recurPreOrderTraversal(rightChild, output, false);
            }
        }
    }

    private void recurInOrderTraversal(TreeNode parent, StringBuilder output, boolean start) {
        int value = parent.getVal();
        if (value != -1) {
            TreeNode leftChild = parent.getLeft();
            TreeNode rightChild = parent.getRight();
            if (leftChild != null) {
                recurInOrderTraversal(leftChild, output, false);
            }
            if (!start) {
                output.append(",");
            }
            output.append(value);
            if (rightChild != null) {
                recurInOrderTraversal(rightChild, output, false);
            }
        }
    }

    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1);
        TreeNode rightChild = new TreeNode(2);
        rightChild.setLeft(new TreeNode(3));
        root.setRight(rightChild);
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("pre order traversal->" + binaryTreeTraversal.preOrderTraversal(root));
        System.out.println("in order traversal->" + binaryTreeTraversal.inOrderTraversal(root));
    }

}
