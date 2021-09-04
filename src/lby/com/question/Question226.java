package lby.com.question;

import lby.com.util.TreeNode;

/*
* 226. 翻转二叉树
*   翻转一棵二叉树。
* 解:
*   思路1: 递归实现, 二叉树的递归,一定要从子树(规模缩减)的视角来看,从上到下看!
*         将子树的业务逻辑描述用文字写出或画出(连写两层-三层,就很明了了)
* */
public class Question226 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        revert(root);
        return root;
    }

    private void revert(TreeNode node){
        if (node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        revert(node.left);
        revert(node.right);
    }
}
