package lby.com.question;


import lby.com.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* 104. 二叉树的最大深度
*   给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
*   说明: 叶子节点是指没有子节点的节点。
* 解:
*   思路1: 用层次遍历的方法记录层数, 此处使用单队列遍历
*   思路2: 用递归实现, 递归函数返回值为左右子树的最大深度+1
* */
public class Question104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        int maxD = 0;
        if (root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                maxD++;
            }
        }
        return maxD;
    }

    public int maxDepth2(TreeNode root) {
        return getMaxD(root);
    }

    private int getMaxD(TreeNode node){
        if (node == null)
            return 0;
        return Math.max(getMaxD(node.right), getMaxD(node.left))+1;
    }
}
