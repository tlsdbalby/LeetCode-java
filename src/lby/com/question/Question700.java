package lby.com.question;


import lby.com.util.TreeNode;

/*
* 700. 二叉搜索树中的搜索
*   给定二叉搜索树（BST, 左小于根，右大于根）的根节点和一个值。你需要在BST中找到节点值等于给定值的节点。
*   返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
* 解:
*   思路1: 递归实现, 传入后判断null
* */
public class Question700 {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
