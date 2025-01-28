import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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

// TC: O(n) as all the nodes are traversed.
// SC: O(n) as Queue is utilized.

// max variable is used to keep the maxnimum value in each level.
public class FindLargestValueinEachTreeRow {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(largestValues(root));
    }

    static List<Integer> result;

    public static List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        bfs(root);
        return result;
    }

    private static void bfs(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            result.add(max);
        }
    }

}