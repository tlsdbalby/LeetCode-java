package lby.com.question;


import lby.com.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* 101. 对称二叉树
*   给定一个二叉树，检查它是否是镜像对称的。
* 解:
*   思路1: 递归判断, 递归函数的两个边界条件: r和l是否同时为null->返回true, 不同时为null->返回false
*                             递归条件: 其余情况
*   思路2: 迭代实现, 使用队列, 一次进两个对称元素, 因此队列中每两个相邻的元素应该是相等的
*
* */
public class Question101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if (root != null){
            return check(root.left, root.right);
        }
        return false;
    }
    private boolean check(TreeNode l, TreeNode r){
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()){
                TreeNode n1 = queue.poll();
                TreeNode n2 = queue.poll();
                if (n1 == null && n2 == null)
                    continue;
                if (n1 == null || n2 == null || n1.val != n2.val)
                    return false;
                //对称元素一起进队
                queue.offer(n1.left);
                queue.offer(n2.right);

                queue.offer(n1.right);
                queue.offer(n2.left);
            }
            return true;
        }
        return false;
    }
}
