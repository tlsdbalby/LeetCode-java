package lby.com.binarytree;

import lby.com.util.ListNode;
import lby.com.util.TreeNode;

import java.util.*;

/*
* 二叉树入门之:遍历
*   从遍历方式上:
*       深度优先遍历dfs: 前中后序遍历
*       广度优先遍历bfs: 层序遍历
*   从遍历算法:
*       回溯(递归)法: 思路清晰, 较为容易
*       迭代法: 难点
*   操作:
*       按序打印 或者 按序保存到集合中
* */
public class Search {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(7);
        TreeNode l11 = new TreeNode(1);
        TreeNode l12 = new TreeNode(4);
        TreeNode r11 = new TreeNode(6);
        TreeNode r12 = new TreeNode(9);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        l1.right = l12;
        r1.left = r11;
        r1.right = r12;

        dfsRecurve(root);
        System.out.println();
        dfsIter(root);
        System.out.println();
        bfsIter(root);
        System.out.println();
        bfs(root);
    }

    public void dfs(ListNode root){

    }
    /*
    * 深度优先遍历回溯法: 将对节点的访问 左孩子访问 右孩子访问 的顺序调整即可得到不同序的遍历
    *   前序: 中左右 中序: 左中右 后序: 左右中
    * */
    public static void dfsRecurve(TreeNode node){
        if (node == null)
            return;
        //此处为中序
        dfsRecurve(node.left);//左孩子 左
        System.out.print(node.val+" ");//对节点的访问 中
        dfsRecurve(node.right);//右孩子 右
    }
    /*
    * 深度优先遍历迭代法: 用栈模拟递归的过程, 然后将每个节点构造成父节点再进行访问! 例如叶子节点是左右孩子为null的子树的父节点!
    *   使用空节点(null)为父节点做标记! 入栈顺序与遍历顺序相反!
    *   将对父节点入栈 左孩子入栈 右孩子入栈 的顺序调整即可得到不同序的遍历
    * */
    public static void dfsIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                //入栈顺序: 右中左, 得到的遍历顺序为中序: 左中右
                if (node.right != null)
                    stack.push(node.right);//右

                stack.push(node);//中
                stack.push(null);//父节点标记

                if (node.left != null)
                    stack.push(node.left);//左
            } else {
                //进入此处说明当前的node是Null, 因此下一个node一定是父节点!
                node = stack.pop();
                System.out.print(node.val+" ");//父节点访问
            }
        }
    }
    /*
    * 广度优先搜索迭代法: 利用队列先进先出的性质完成, 注意每层加入队列时, 要记录本层元素在队列中长度, 实现层次划分
    * */
    public static void bfsIter(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);
        while (!queue.isEmpty()){
            //英因为在下面的for中queue长度在变化, 因此不能使用queue.size()进行for循环, 必须在开始本层遍历前记录本层节点数量
            int curLength = queue.size();
            for (int i = 0; i < curLength; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }
    /*
    * 广度优先搜索回溯法(递归): 使用数组来保存每层元素，约等于用组数模拟队列（将队列按树的层次划分为多个数组）
    * */
    public static void bfs(TreeNode root){
        if (root == null)
            return;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        bfsRecurve(list);
    }
    public static void bfsRecurve(List<TreeNode> nodeList){
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodeList) {
            System.out.print(node.val+" ");
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
        if (!list.isEmpty())
            bfsRecurve(list);
    }
}
