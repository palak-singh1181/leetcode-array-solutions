import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(TreeNode node, int target,
                            List<Integer> path,
                            List<List<Integer>> ans) {

        if (node == null)
            return;

        path.add(node.val);

        if (node.left == null && node.right == null && target == node.val) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, target - node.val, path, ans);
            dfs(node.right, target - node.val, path, ans);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}