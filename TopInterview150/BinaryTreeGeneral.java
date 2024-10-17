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
}