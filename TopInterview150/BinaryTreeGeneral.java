package TopInterview150;

public class BinaryTreeGeneral {
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // 104. Maximum Depth of Binary Tree
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return 1 + Math.max(leftDepth, rightDepth);
  }

  // 100. Same Tree
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null)
      return true;
    if (p == null || q == null || p.val != q.val)
      return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  // 226. Invert Binary Tree
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }

  // 101. Symmetric Tree
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;
    if (t1 == null || t2 == null)
      return false;
    return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
  }

  // 112. Path Sum
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
      return false;

    if (root.left == null && root.right == null)
      return root.val == targetSum;

    boolean leftHasPathSum = hasPathSum(root.left, targetSum - root.val);
    boolean rightHasPathSum = hasPathSum(root.right, targetSum - root.val);

    return leftHasPathSum || rightHasPathSum;
  }
}