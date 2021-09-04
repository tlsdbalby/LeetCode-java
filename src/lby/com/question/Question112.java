package lby.com.question;

import lby.com.util.TreeNode;

/*
* 112. 路径总和
*   给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
*   这条路径上所有节点值相加等于目标和 targetSum 。
*   叶子节点 是指没有子节点的节点。
* 解:
*   思路1: 递归实现, 边界条件: 无子树,且当前目标值-本节点值 == 0
*                 非边界条件: 有子树 每次递归缩减目标值, 选择子树(缩减规模)
* */
public class Question112 {
    private boolean re = false;
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null)
            isExist(root, targetSum);
        return re;
    }
    private void isExist(TreeNode node, int curTarget){
        if (node.left == null && node.right == null)
            if ((curTarget-node.val) == 0)
                re = true;
        if (node.left != null)
            isExist(node.left, curTarget-node.val);
        if (node.right != null)
            isExist(node.right, curTarget-node.val);
    }
}
