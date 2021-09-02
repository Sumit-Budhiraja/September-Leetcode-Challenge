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
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);        
    }
            
   public List<TreeNode> solve(int start, int end){
       List<TreeNode> res = new ArrayList<TreeNode>();
       
        if(start > end){
            res.add(null);
            return res;
        }else if(start == end){
            res.add(new TreeNode(start));            
            return res;
        }else{
            for(int i = start; i <= end; i++){
                List<TreeNode> leftAns = solve(start, i - 1);
                List<TreeNode> rightAns = solve(i + 1, end);
                
                for(TreeNode lchild : leftAns){
                    for(TreeNode rchild : rightAns){
                        TreeNode root = new TreeNode(i);
                        root.left = lchild;
                        root.right = rchild;
                        res.add(root);  
                    }
                }
            }
        }   
        return res;
    }
}