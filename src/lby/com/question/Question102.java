package lby.com.question;

import lby.com.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 102. 二叉树的层序遍历
*   给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
* 解:
*   思路1: 递归实现, 递归参数携带层次信息, 难点:由于事先不知道树有几层,所以如何动态扩展层次结构?
*   思路2: 双队列实现, 一个队列放当前层的节点,一个放下一层的节点
*   思路3: 单队列实现, 每次遍历一层前,先记录每本层的节点数量,避免遍历过程中添加新节点造成跨层遍历(是思路2的改进版)
* */
public class Question102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            getVal(lists, 0, root);
        }
        return lists;
    }
    private void getVal(List<List<Integer>> lists, int c, TreeNode node){
        if (node != null){
            //若是 lists的长度低于当前递归函数需要的层次深度,那么创建新层次,并放入lists(当且仅当每个层次的第一个递归执行一次)
            if (lists.size()-1 < c){
                List<Integer> list = new ArrayList<>();
                lists.add(list);
            }
            lists.get(c).add(node.val);
            getVal(lists, c+1, node.left);
            getVal(lists, c+1, node.right);
        }
    }

    //巧用下标, 建立双队列下标和层数关系!
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){
            Queue<TreeNode>[] q = new LinkedList[2];
            q[0] = new LinkedList<>();
            q[1] = new LinkedList<>();
            int c = 0;
            lists.add(new ArrayList<>());
            q[c].offer(root);
            while (true){
                TreeNode node = q[c%2].poll();
                lists.get(c).add(node.val);
                if (node.left != null)
                    q[1-c%2].offer(node.left);
                if (node.right != null)
                    q[1-c%2].offer(node.right);
                if (q[c%2].isEmpty()){
                    if (q[1-c%2].isEmpty())
                        break;
                    c++;
                    List<Integer> list = new ArrayList<>();
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // 是否还有节点
            while (!queue.isEmpty()){
                List<Integer> list = new LinkedList<>();
                int curSize = queue.size();
                // 层次遍历
                for (int i = 0; i < curSize; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
