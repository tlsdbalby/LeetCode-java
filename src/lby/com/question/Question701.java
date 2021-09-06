package lby.com.question;


import lby.com.util.TreeNode;

/*
* 701. 二叉搜索树中的插入操作
*   给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
*   输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
*   注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果
* 解:
*   思路1: 递归实现, 永远插到叶子节点下
* */
public class Question701 {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        addNewNode(root, val);
        return root;
    }
    private void addNewNode(TreeNode node, int val){
        if (node.val < val){
            if (node.right != null)
                addNewNode(node.right, val);
            else node.right = new TreeNode(val);
        }
        if (node.val > val){
            if (node.left != null)
                addNewNode(node.left, val);
            else node.left = new TreeNode(val);
        }
    }
}
