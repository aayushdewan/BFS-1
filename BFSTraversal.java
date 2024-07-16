
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Tc --> O(n)
 * Sc --> O(n) for the Queue
 */
import java.util.*;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        bfs(root);
        //System.out.print(res);
        return res;
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        res.add(new ArrayList<>(values));
        values.clear();

        while (!q.isEmpty()) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    values.add(node.left.val);
                    q.add(node.left);

                }//if

                if (node.right != null) {

                    values.add(node.right.val);
                    q.add(node.right);

                }//if

            }//for

            if (values.size() > 0) {

                //System.out.println(values);
                res.add(new ArrayList<>(values));

            }

            values.clear();
            //System.out.println("res"+ res);

        }//while
    }//method
}//class
