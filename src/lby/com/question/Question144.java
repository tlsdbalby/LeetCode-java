package lby.com.question;

import lby.com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* 144. 二叉树的前序遍历:中 左 右
*   给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
* 解
*   思路1: 递归实现,输出自身 左孩子递归 右孩子递归
*   思路2: 用迭代模拟递归,使用栈来实现, 对于前序遍历: 中 左 右,则输出中,然后右先入栈,左后入栈!以此实现先左后右
*       为什么不能用队列? 因为队列先进先出, root的左右节点入队,相对位置就定死了,无法再插入子节点的孩子节点了!
* */
public class Question144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null)
            getVal(list, root);
        return list;
    }
    //交换list.add() 与 左孩子递归 右孩子递归的顺序,就是 中序和后序遍历
    private static void getVal(List<Integer> list, TreeNode node){
        list.add(node.val);
        if (node.left != null)
            getVal(list, node.left);
        if (node.right != null)
            getVal(list, node.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        return list;
    }
}
