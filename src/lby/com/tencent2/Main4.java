package lby.com.tencent2;

import lby.com.util.TreeNode;

import java.util.HashMap;

public class Main4 {
    public static void main(String[] args) {

    }

    public static TreeNode solve (TreeNode root, int[][] b) {
        // write code here
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        getTree(root, hashMap);

        return root;
    }

    public static void getTree(TreeNode node, HashMap<Integer, TreeNode> hashMap){
        if (node == null)
            return;
        hashMap.put(node.val, node);
        getTree(node.left, hashMap);
        getTree(node.right, hashMap);
    }
}
