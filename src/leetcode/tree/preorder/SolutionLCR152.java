package leetcode.tree.preorder;

public class SolutionLCR152 {
    public boolean verifyTreeOrder(int[] postorder) {
        return doVerifyTreeOrder(postorder, 0, postorder.length - 1);
    }

    private boolean doVerifyTreeOrder(int[] postOrder, int left, int root) {
        if (left >= root) {
            return true;
        }

        int right = left;
        while (right < postOrder.length && postOrder[right] < postOrder[root]) {
            right++;
        }
        int tempRight = right;
        while (tempRight < postOrder.length && postOrder[tempRight] > postOrder[root]) {
            tempRight++;
        }

        return tempRight == root
                && doVerifyTreeOrder(postOrder, left, right - 1) && doVerifyTreeOrder(postOrder, right, root - 1);
    }
}
