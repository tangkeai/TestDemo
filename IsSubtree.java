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
 */

class Solution {
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t != null || s!= null && t == null) return false;
        if(s == null && t == null) return true;
        if(s.val != t.val) return false;
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        if(isSameTree(s ,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }
}