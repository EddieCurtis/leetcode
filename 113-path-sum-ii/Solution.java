/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> valid = new ArrayList<List<Integer>>();
        searchRecursive(root, valid, new Stack<>(), sum, 0);
        return valid;
    }
    
    private void searchRecursive(TreeNode current, List<List<Integer>> results, Stack<Integer> currentStack, int target, int currentSum) {
        if (current == null) {
            return;
        }
        currentSum += current.val;
        
        if (currentSum == target && current.left == null && current.right == null) {
                List<Integer> result = new ArrayList<>(currentStack);
                result.add(current.val);
                results.add(result);
                return;
        } else {
            if (current.left != null) {
                currentStack.push(current.val);
                searchRecursive(current.left, results, currentStack, target, currentSum);
                currentStack.pop();
            }
            
            if (current.right != null) {
                currentStack.push(current.val);
                searchRecursive(current.right, results, currentStack, target, currentSum);
                currentStack.pop();
            }
        }
    }
}
